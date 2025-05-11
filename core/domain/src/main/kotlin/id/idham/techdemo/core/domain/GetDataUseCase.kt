package id.idham.techdemo.core.domain

import id.idham.techdemo.core.data.repository.DemoRepository
import id.idham.techdemo.core.model.Result
import id.idham.techdemo.core.model.data.Data
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDataUseCase @Inject constructor(
    private val repository: DemoRepository,
) {
    operator fun invoke(): Flow<Result<List<Data>>> = repository.getDataStream()
}
