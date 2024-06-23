```mermaid
---
title: GitHub Model Class
---
classDiagram
    ApiClientProvider ..> ApiClient : create
    ApiClientProvider ..> Builder : use
    ApiClientModule ..> ApiClientProvider : use

    RemoteDataSource <|-- RemoteDataSourceImpl : implements
    RemoteDataSourceModule ..> RemoteDataSourceImpl : inject
    UserRepository <|-- UserRepositoryImpl : implements
    UserRepositoryImpl *-- RemoteDataSource

    DaggerHilt ..> ApiClientModule : use
    DaggerHilt ..> ApiClientProvider : inject
    DaggerHilt ..> RemoteDataSourceModule : use
    DaggerHilt ..> UserRepositoryModule : use
    UserRepositoryModule ..> UserRepositoryImpl : inject

    DaggerHilt ..> MainViewModel : inject

    MainViewModel *-- UserRepository
    
    namespace Retrofit {
        class Builder {

        }
    }


    class ApiClientProvider {
        +provide() ApiClient
    }

    class RemoteDataSourceModule {
        +provideRemoteDataSource(RemoteDataSourceImpl remoteDataSourceImpl) RemoteDataSource
        
    }

    class UserRepositoryModule {
        +provideUserRepository(UserRepositoryImpl userRepositoryImpl) UserRepository
        
    }

    class ApiClient{
        <<interface>> 
        getGitHubUser(String userName)
    }
    class ApiClientModule {
        +provideApiClient(ApiClientProvider apiClientProvider) ApiClient
    }


    class RemoteDataSource{
        <<interface>> 
        getGitHubUser(String userName)
    }



    class User{
        +UserId userId
        +String name
        +NetworkImage avatarImage
        +Url blogUrl
    }
    class UserId{
        +Long value
    }
    class NetworkImage{
        +Url url
    }
    class Url{
        +String value
    }
```
