package at.chrispi.teamranking.network

class DataState<T>(
    val hasData: Boolean,
    val message: String?,
    val code: Int?,
    val data: T?,
)