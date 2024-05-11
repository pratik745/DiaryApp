package com.example.diaryapp.domain.repository

import com.example.diaryapp.data.models.Response
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.firebase.auth.AuthCredential


typealias OneTapSignInResponse = Response<BeginSignInResult>
typealias SignInWithGoogleResponse = Response<Boolean>


interface AuthenticationRepository {

    val isUserAuthenticated: Boolean

    suspend fun oneTapSignInWithGoogle(): OneTapSignInResponse

    suspend fun mongoDbSignInWithGoogle(googleCredentials: AuthCredential): SignInWithGoogleResponse
}