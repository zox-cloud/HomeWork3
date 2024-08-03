package kz.singularity.jetpackcomposemost
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.material3.Button
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import kz.singularity.jetpackcomposemost.ui.theme.JetpackComposeMostTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            JetpackComposeMostTheme {
//               HelloScreen()
//            }
//        }
//    }
//}
//
//
//@Composable
//fun HelloScreen(){
//    val viewModel : HelloViewModel = viewModel()
//    val state by viewModel.state
//    HelloContent(
//        state = state,
//        onNameChanged = { viewModel.onNameChanged(it) },
//        onCounterButtonClicked = { viewModel.onCounterButtonClicked() }
//    )
//
//
//}
//
//@Composable
//fun HelloContent(
//    state: HelloState,
//    onNameChanged: (String) -> Unit,
//    onCounterButtonClicked : () -> Unit
//
//){
//    Column(modifier = Modifier.padding(16.dp)){
//
//
//        if(state.name.isNotEmpty()){
//            HelloText(name = state.name)
//        }
//
//        OutlinedTextField(
//            value = state.name,
//            onValueChange = onNameChanged,
//            label = {Text("Name")}
//            )
//
//        CounterElement(
//            currentCountNumber = state.counter,
//            onCounterButtonClicked = onCounterButtonClicked
//        )
//    }
//}
//
//
//@Composable
//fun HelloText(
//    name : String
//){
//    Text(
//        text = "Hello $name",
//        modifier = Modifier.padding(bottom = 8.dp),
//        style = MaterialTheme.typography.bodyMedium
//    )
//}
//
//@Composable
//fun CounterElement(
//    currentCountNumber : Int,
//    onCounterButtonClicked: () -> Unit
//){
//    Text(text = "Counter =  $currentCountNumber")
//    Button(onClick = onCounterButtonClicked) {
//        Text(text = "Click me ")
//    }
//}
//
//@Preview
//@Composable
//fun HelloContentPreview(){
//    JetpackComposeMostTheme {
//      HelloScreen()
//    }
//}

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import kz.singularity.jetpackcomposemost.ui.theme.JetpackComposeMostTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {

            JetpackComposeMostTheme {
                LazyColumn {
                    item(50) {
                        PostDetailsScreenPreview()

                    }
                }



            }
        }
    }
}


@Preview
@Composable
fun PostPreview(){
    JetpackComposeMostTheme {
        LazyColumn {
            item(50) {
                PostDetailsScreenPreview()

            }

            

        }
    }
}

@Composable
fun PostDetailsScreenPreview(){
    val postViewModel = PostViewModel()
    PostDetailsScreen(postViewModel = postViewModel)
}

@Composable
fun PostDetailsScreen(postViewModel: PostViewModel){

    val post by postViewModel.post.collectAsState()

    PostContent(
        post = post,
        onTitleChange = { postViewModel.onTitleChange(it) },
        onContentChange = { postViewModel.onContentChange(it) }
    )

}

@Composable
fun PostContent(
    post : Post,
    onTitleChange : (String) -> Unit,
    onContentChange : (String) -> Unit


){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        BasicTextField(
            value = post.title,
            onValueChange = onTitleChange,
            textStyle = TextStyle(fontSize = 20.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 0.dp)
                .height(56.dp),
            decorationBox = { innerTextField ->
                if (post.title.isEmpty()) {
                    Text(text = "Post title", style = TextStyle(fontSize = 18.sp))
                }
                innerTextField()
            }
        )

        BasicTextField(
            value = post.content,
            onValueChange = onContentChange,
            textStyle = TextStyle(fontSize = 18.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .height(150.dp),
            decorationBox = { innerTextField ->
                if (post.content.isEmpty()) {
                    Text(text = "Content here", style = TextStyle(fontSize = 18.sp))
                }
                innerTextField()
            }
        )
    }

}









