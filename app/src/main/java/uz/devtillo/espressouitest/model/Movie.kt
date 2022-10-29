package uz.devtillo.espressouitest.model

data class Movie(
    val id: Int ?=null,
    val title: String?=null,
    val image: String?=null,
    val description: String?=null,
    val directors: ArrayList<String>?=null,
    val star_actors: ArrayList<String>?=null
) : java.io.Serializable