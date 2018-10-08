# POC_RestService
This POC contains an implementation for a simple REST Service based on the following libraries
* [Retrofit](https://square.github.io/retrofit/)
* [OkHttp](https://square.github.io/okhttp/#examples)
## RestService without authentication
The implemenation of explanation which follows can be found in the [typicode](https://github.com/BMSGIBB/POC_RestClient/tree/master/src/main/java/com/test/restclientlibrary/restclient/test/jsontypicode) folder and is show an rest servcie for the [JSONPlaceholderTypicode endpoint](https://github.com/BMSGIBB/POC_RestClient/tree/master/src/main/java/com/test/restclientlibrary/restclient/test/jsontypicode)
### Setup
The service, in this case called "TypicodeRestService", must `extend` the RestService class. The content of the implemented abstract method `createRetrofitConfiguration`
repersents the configuration of the OkHttpClient which is responsible to handle every request. Due to perofmance reasons all OkHttpClient instance are using a core OkHttpClient
which is provided by the RestService.

> Default implemenation for `IRetrofitConfiguration` can be found in the Classes [RetrofitConfigurationTemplate](https://github.com/BMSGIBB/POC_RestClient/blob/master/src/main/java/com/test/restclientlibrary/restclient/supply/RetrofitConfigurationTemplate.java) and [RetrofitInterceptorTemplate](https://github.com/BMSGIBB/POC_RestClient/blob/master/src/main/java/com/test/restclientlibrary/restclient/supply/RetrofitInterceptorTemplate.java)

```
@Service
public class TypicodeRestService extends RestService {

    @Autowired
    public TypicodeRestService(IRetrofitGenerator retroFitGenerator, IRetrofitConfigurationTemplate retrofitConfigurationTemplate, IRetrofitInterceptorTemplate retrofitInterceptorTemplate) {
        super(retroFitGenerator, retrofitConfigurationTemplate, retrofitInterceptorTemplate);
    }

    @Override
    public IRetrofitConfiguration createRetrofitConfiguration() {
        return configurationTemplate.noAuthentication("https://jsonplaceholder.typicode.com");
    }

    public Observable<List<PostDto>> getPostWithIds(List<Integer> idList){
        TypicodeRequest typicodeRequest = retrofit.create(TypicodeRequest.class);
        Observable<List<PostDto>> listObservable = Observable
                .from(idList)
                .flatMap(typicodeRequest::getPost)
                .toList()
                .subscribeOn(Schedulers.io());
        return listObservable;
    }
}
```
