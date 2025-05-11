package id.idham.techdemo.core.data.repository

import id.idham.techdemo.core.data.utils.NetworkMonitor
import id.idham.techdemo.core.model.ErrorType
import id.idham.techdemo.core.model.Result
import id.idham.techdemo.core.model.data.Data
import id.idham.techdemo.core.network.endpoint.DemoApiService
import id.idham.techdemo.core.network.model.NetworkData
import id.idham.techdemo.core.network.model.asExternalModel
import id.idham.techdemo.core.network.utils.ResultWrapper
import id.idham.techdemo.core.network.utils.safeApiCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultDemoRepository @Inject constructor(
    private val api: DemoApiService,
    private val networkMonitor: NetworkMonitor,
) : DemoRepository {

    override fun getDataStream(): Flow<Result<List<Data>>> = flow {
        emit(Result.Loading)
        if (!networkMonitor.isOnline.first()) {
            emit(Result.Error(ErrorType.NetworkError))
            return@flow
        }

        when (val response = safeApiCall { api.getData() }) {
            is ResultWrapper.Success -> {
                emit(Result.Success(response.data.map(NetworkData::asExternalModel)))
            }

            is ResultWrapper.Error -> {
                emit(Result.Error(response.error))
            }
        }
    }
}
