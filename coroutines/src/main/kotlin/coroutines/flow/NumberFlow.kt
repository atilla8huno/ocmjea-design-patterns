package coroutines.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class NumberFlow {
    fun doubled(): Flow<Int> = flowOf(1, 2, 3).map { it * 2 }
}
