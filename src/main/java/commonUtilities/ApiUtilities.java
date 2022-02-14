package commonUtilities;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtilities {

	public static Float jsonSearchedKeyValue;

	public static Response response() {
		RestAssured.baseURI = AutoConstant.url;
		RequestSpecification request = RestAssured.given();
		Response response = request.queryParam(AutoConstant.cityName_key, AutoConstant.cityName_value)
				.queryParam(AutoConstant.token_key, AutoConstant.token_value).get(AutoConstant.resource);
		String json = response.asPrettyString();
		System.out.println(json);
		System.out.println(response.getStatusCode());
		return response;
	}

	public static Float responseBody(String key, String keyPath) {
		Map<String, Float> jsonPathEvaluator = ApiUtilities.response().jsonPath().getMap(key);
		jsonSearchedKeyValue = jsonPathEvaluator.get(keyPath) ;
		return jsonSearchedKeyValue;
	}
}
