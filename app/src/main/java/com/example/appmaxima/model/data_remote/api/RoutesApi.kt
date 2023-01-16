package com.example.appmaxima.model.data_remote.api

import com.example.appmaxima.model.model.cliente.ClienteResponse
import com.example.appmaxima.model.model.pedido.PedidoListResponse
import retrofit2.Response
import retrofit2.http.GET

interface RoutesApi {
    @GET("cliente")
    suspend fun getCliente(): Response<ClienteResponse>

    @GET("pedido")
    suspend fun getPedidos(): Response<PedidoListResponse>
}