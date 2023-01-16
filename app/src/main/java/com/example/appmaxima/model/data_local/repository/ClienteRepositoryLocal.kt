package com.example.appmaxima.model.data_local.repository

import androidx.lifecycle.LiveData
import com.example.appmaxima.model.data_local.dao.ClienteDao
import com.example.appmaxima.model.model.cliente.Cliente

class ClienteRepositoryLocal(private val clienteDao: ClienteDao) {

    var readCliente: LiveData<List<Cliente>> = clienteDao.readCliente()

    suspend fun addCliente(cliente: Cliente) {
        clienteDao.addClient(cliente)

    }

    fun getCliente(): List<Cliente> {
        return clienteDao.getClient()
    }

}