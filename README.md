# E-CommerceApp

Android Kotlin Clean Architecture App
=======================================

A Clean Architecture App that uses feature Modularization Architecture (app, presentation, domain, data) modules
to use coffee items  API using MVVM Architecture, Coroutines, Retrofit2, Pagination, Live Data, Data Binding, Hilt , SOLID Principles , Navigation Component , RoomDb.

##ScreenShots 
![image](https://user-images.githubusercontent.com/60134186/185239950-3794fae2-566d-484c-adf2-1e8d977176fd.png)
![image](https://user-images.githubusercontent.com/60134186/185240793-7ed0f99b-0d4a-4b06-ae53-ee99e0c28666.png)
![image](https://user-images.githubusercontent.com/60134186/185240852-93c133bc-e319-4d1b-8479-c93a0f1301b5.png)
![image](https://user-images.githubusercontent.com/60134186/185240909-ad217dec-e89e-4b3c-ab5e-f87007c187e6.png)

https://user-images.githubusercontent.com/60134186/185241666-38bb1c68-fc56-4ddc-b37c-ac6de5ab6508.mp4



Introduction
-------------

### Layers
![3layer-1](https://user-images.githubusercontent.com/39988066/147699856-bc10356a-4772-439d-a2c1-b6020843f936.png)

#### UI or Presentation Layer
- This layer has all the Android UI components like Activities, Fragments, ViewModels, etc.

#### Domain Layer
- Contains all the business logic of the app. This layer has no Android components in it.

#### Data Layer
- All components related to data such as database, networking, api, shared preferences. It is an Android specific layer.

### Modules
![depends](https://user-images.githubusercontent.com/39988066/147700089-345e1a60-1651-4121-8616-f9273f8e0412.png)

#### App Module
- Considered as entery point for the app
- Contains (Activity) that hosts presentation view
- Contatins BaseApplication and all needed app info

#### Domain Module
- Contains business model 
- Contains business USECASES
- Repository interface

#### Data Module
- Repository Implementation
- Executor API data
- Mapper data model to domain model
- Contains data service, third party data service  

#### Presentation Module
- View (Fragment/Layout) Adapt data to view 
- Follows MVVM Architecture
- Mapper domain model to presentation model
- Handle data input from view via UseCase


