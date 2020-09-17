# ADNewsApp

<img src="https://github.com/AkshataAppDev/ADNewsApp/blob/master/Screenshot_20200917-181904_ADNewsApp.png" width="300" height="500"/> List of items show using a Staggered Layout

<img src="https://github.com/AkshataAppDev/ADNewsApp/blob/master/Screenshot_20200917-181916_ADNewsApp.png" width="300" height="500"/> In-app browser implemented using webview


A sample News App that displays news items downloaded from newsapi.org.
News items are downloaded by calling a request URL from newsapi and are populated using Recycler View. When user taps on any news item, a new fragment is opened
to open the url
The data is not currently persisted anywhere as the requirement is just to download and show the items in recycler view. Persistant storage can be implemented using Room(or other lib.) in a future version of the app. This would also be integrated using JetPack architecture(MVVM).

Features :
1. Kotlin
2. RecyclerView
2. ViewModels
3. DataBinding
4. Safe Args
5. Retrofit
6. Moshi JSON library
7. Glide Library
8. Material Card Component

Building Steps: 
Project should be downloaded and built using Android Studio just as a normal Kotlin project.

