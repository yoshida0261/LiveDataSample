package jp.co.stah.livedatasample


interface Factory<T> {

    fun create(model: Class<T>): T
}
