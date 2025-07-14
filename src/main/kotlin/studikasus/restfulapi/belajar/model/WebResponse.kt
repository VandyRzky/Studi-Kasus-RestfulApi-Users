package studikasus.restfulapi.belajar.model

data class WebResponse<T> (
    var data:T? = null,
    var errors:String? = null
)