package com.example.diaryapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diaryapp.data.models.Response.*
import com.example.diaryapp.domain.repository.AuthenticationRepository
import com.example.diaryapp.domain.repository.OneTapSignInResponse
import com.example.diaryapp.domain.repository.SignInWithGoogleResponse
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.AuthCredential
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthenticationRepository,
    val oneTapClient: SignInClient
):ViewModel() {
    val isUserAuthenticated get() = authRepository.isUserAuthenticated

    var oneTapSignInResponse by mutableStateOf<OneTapSignInResponse>(Success(null))
        private set

    var signInWithGoogleResponse by mutableStateOf<SignInWithGoogleResponse>(Success(null))
        private set

    fun oneTapSignIn() = viewModelScope.launch {
        oneTapSignInResponse = Loading
        oneTapSignInResponse = authRepository.oneTapSignInWithGoogle()

    }

    fun signInWithGoogle(googleCredentials: AuthCredential) = viewModelScope.launch {
        signInWithGoogleResponse = Loading
        signInWithGoogleResponse = authRepository.mongoDbSignInWithGoogle(googleCredentials)
    }
}