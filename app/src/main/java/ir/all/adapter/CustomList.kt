package ir.all.adapter

class CustomList(titr: String, imageId: Int) {

    private var _titr: String
    private var _imageId: Int

    init {
        _titr = titr
        _imageId = imageId
    }

    public fun getTitr() = _titr
    public fun getImageid() = _imageId
    override fun toString() = _titr

}