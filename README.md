# POC_RestClient
This POC contains an implementation for a simple REST client based on the following libraries
* [Retrofit](https://square.github.io/retrofit/)
* [OkHttp](https://square.github.io/okhttp/#examples)
## RestService without authentication
The implemenation of explanation which follows can be found in the [typicode](https://github.com/BMSGIBB/POC_RestClient/tree/master/src/main/java/com/test/restclientlibrary/restclient/test/jsontypicode) folder and is show an rest servcie for the [JSONPlaceholderTypicode endpoint](https://github.com/BMSGIBB/POC_RestClient/tree/master/src/main/java/com/test/restclientlibrary/restclient/test/jsontypicode)
### Setup
The service, in this case called "TypicodeRestService", must `extend` the RestService class. The content of the implemented abstract method `createRetrofitConfiguration`
repersents the configuration of the OkHttpClient which is responsible to handle every request. Due to perofmance reasons all OkHttpClient instance are using a core OkHttpClient
which is to disposal by the RestClient.
