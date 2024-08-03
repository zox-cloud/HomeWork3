package kz.singularity.jetpackcomposemost

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


data class Post(

    val title: String = "",
    val content : String = ""

)
class PostViewModel : ViewModel(){
    private val _post = MutableStateFlow(Post())
    val post : StateFlow<Post> get() = _post


    fun onTitleChange(newTitle : String){
        _post.value = _post.value.copy(title = newTitle)
    }

    fun onContentChange(newContent: String){
        _post.value = _post.value.copy(content = newContent)
    }
}