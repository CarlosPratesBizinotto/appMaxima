package com.example.appmaxima.model.data_remote.repository.reoisitory_remote

import com.example.appmaxima.model.data_remote.api.Api
import com.example.appmaxima.model.model.cliente.ClienteResponse
import com.example.appmaxima.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class ClienteRepository {

    private var clientRoute = Api(Constants.BASE_URL).create()

    suspend fun getCliente(): Flow<ClienteResponse> {
        return flow {
            clientRoute.getCliente()
                .let { response ->
                    if (response.isSuccessful) {
                        response.body()
                    } else {
                        throw HttpException(response)

                    }
                }?.let {
                    emit(it)
                }
        }
    }
}