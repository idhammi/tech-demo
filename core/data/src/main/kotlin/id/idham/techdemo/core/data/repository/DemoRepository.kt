package id.idham.techdemo.core.data.repository

import id.idham.techdemo.core.model.Result
import id.idham.techdemo.core.model.data.Data
import kotlinx.coroutines.flow.Flow

interface DemoRepository {
    fun getDataStream(): Flow<Result<List<Data>>>
}
