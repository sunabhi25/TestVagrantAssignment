package commonUtilities;

/*
 * This class ApiUtilities basically has been written in order to get the response of the api request once we have 
 * the response from the response we will take the values which so ever required in form of key-value pair.
 * 
 * @author Abhishek Shandilya
 */

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtilities {

	public static Float jsonSearchedKeyValue;

	/*
	 * Method to get the response from the API 
	 */
	public static Response response() {
		RestAssured.baseURI = AutoConstant.url;
		RequestSpecification request = RestAssured.given();
		Response response = request.queryParam(AutoConstant.cityName_key, AutoConstant.cityName_value)
				.queryParam(AutoConstant.token_key, AutoConstant.token_value).get(AutoConstant.resource);
		String json = response.asPrettyString();
		return response;
	}

	/*
	 * Method to read json body and from the body it can extract the required value of the key
	 */
	public static Float responseBody(String key, String keyPath) {
		Map<String, Float> jsonPathEvaluator = ApiUtilities.response().jsonPath().getMap(key);
		jsonSearchedKeyValue = jsonPathEvaluator.get(keyPath) ;
		return jsonSearchedKeyValue;
	}
}
