package com.example.appmaxima.presentation.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.appmaxima.model.data_local.database.DatabaseLocal
import com.example.appmaxima.model.data_local.repository.PedidoRepositoryLocal
import com.example.appmaxima.model.data_remote.repository.reoisitory_remote.PedidoRepository
import com.example.appmaxima.model.model.pedido.PedidoListResponse
import com.example.appmaxima.model.model.pedido.Pedido
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class PedidoViewModel(application: Application) : AndroidViewModel(application) {

    private val pedidoRepository: PedidoRepository = PedidoRepository()
    private var pedidoRepositoryLocal: PedidoRepositoryLocal

    var getPedido: LiveData<List<Pedido>>

    private val _pedidoSuccess: MutableLiveData<PedidoListResponse> = MutableLiveData()
    val pedidoSuccess: LiveData<PedidoListResponse> = _pedidoSuccess

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> = _error

    init {
        val pedidoDao = DatabaseLocal.getDatabase(
            application
        ).pedidoDao()
        pedidoRepositoryLocal = PedidoRepositoryLocal(pedidoDao)
        getPedido = pedidoRepositoryLocal.getPedido
    }

    fun addPedido(pedidos: PedidoListResponse) {
        viewModelScope.launch(Dispatchers.IO) {
            pedidos.pedidosResponse.forEach {
                pedidoRepositoryLocal.addPedido(it)
            }
        }
    }

    fun getPedidos() {
        viewModelScope.launch(Dispatchers.IO) {
            pedidoRepository.getPedido()
                .catch { exception ->
                    _error.postValue(exception.message)
                }.collect {
                    _pedidoSuccess.postValue(it)
                }
        }
    }
}