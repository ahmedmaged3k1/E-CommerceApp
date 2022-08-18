# E-CommerceApp

A Clean Architecture App that uses clean Architecture (app, presentation, domain, data) packages 
to use coffee items  API using MVVM Architecture, Coroutines, Retrofit2, Pagination, Live Data, Data Binding, Hilt , SOLID Principles , Navigation Component , RoomDb.


Introduction
-------------
### MVVM Architecture 
![mvvm](https://user-images.githubusercontent.com/60134186/185244558-c3916e54-5300-4fdd-9667-bfb946ed0130.png)


### Layers
![images](https://user-images.githubusercontent.com/60134186/185244485-b13564a5-ec3d-4524-b915-d91aa5dab906.jpg)

#### UI or Presentation Layer
- This layer has all the Android UI components like Activities, Fragments, ViewModels, etc.

#### Domain Layer
- Contains all the business logic of the app. This layer has no Android components in it.

#### Data Layer
- All components related to data such as database, networking, api, shared preferences. It is an Android specific layer.

### Packages 
![depends](https://user-images.githubusercontent.com/39988066/147700089-345e1a60-1651-4121-8616-f9273f8e0412.png)

#### Presentation Package
- Considered as entery point for the app
- Contains (Activity) that hosts presentation view
- Single Activity App

#### Domain Package
- Contains business model 
- Contains business USECASES
- Repository interface

#### Data Package
- Repository Implementation
- Executor API data
- Mapper data model to domain model
- Contains data service, third party data service  

#### Presentation Package
- View (Fragment/Layout) Adapt data to view 
- Follows MVVM Architecture
- Handling Bussiness Logic from view model by databinding 

##ScreenShots 
![image](https://user-images.githubusercontent.com/60134186/185239950-3794fae2-566d-484c-adf2-1e8d977176fd.png)
![image](https://user-images.githubusercontent.com/60134186/185240793-7ed0f99b-0d4a-4b06-ae53-ee99e0c28666.png)
![image](https://user-images.githubusercontent.com/60134186/185240852-93c133bc-e319-4d1b-8479-c93a0f1301b5.png)
![image](https://user-images.githubusercontent.com/60134186/185240909-ad217dec-e89e-4b3c-ab5e-f87007c187e6.png)



