package io.github.mat3e;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HelloServiceTest {

	private final static String WELCOME = "Hello";
	private final static String FALLBACK_ID_WELCOME = "Hola";

	@Test
	void nullNamePrepareGreetingReturnsFallbackValue() {
		//given
		var mockRepository = alwaysReturningHelloRepository();
		var SUT = new HelloService(mockRepository);
		String name = null;
		String expectedResult = WELCOME + " " + HelloService.FALLBACK_NAME + "!";
		//when
		String result = SUT.prepareGreeting(null,"-1");
		//then
		assertThat(result).isEqualTo(expectedResult);
	}

	@Test
	void namePrepareGreetingReturnsGreetingWithName () {
		//given
		var mockRepository = alwaysReturningHelloRepository();
		var SUT = new HelloService(mockRepository);
		String name = "Piotr";
		String expectedResult = "Hello " + name + "!";
		//when
		String result = SUT.prepareGreeting(name,"-1");
		//then
		assertThat(result).isEqualTo(expectedResult);
	}

	@Test
	void namePrepareNullLangGreetingReturnsGreetingWithFallbackIdLang () {
		//given
		var mockRepository = fallBackLangIdRepository();
		var SUT = new HelloService(mockRepository);
		//when
		var result = SUT.prepareGreeting(null,null);
		//then
		assertThat(result).isEqualTo(FALLBACK_ID_WELCOME+" "+HelloService.FALLBACK_NAME+"!");
	}

	@Test
	void namePrepareTextLangGreetingReturnsGreetingWithFallbackIdLang () {
		//given
		var mockRepository = fallBackLangIdRepository();
		var SUT = new HelloService(mockRepository);
		//when
		var result = SUT.prepareGreeting(null,"abc");
		//then
		assertThat(result).isEqualTo(FALLBACK_ID_WELCOME+" "+HelloService.FALLBACK_NAME+"!");
	}

	@Test
	void test_prepareGreeting_nonExistingLang_returnsGreetingWithFallbackLang(){
		//given
		var mockRepository = new LangRepository(){
			@Override
			Optional<Lang> findById(Integer id) {
				return Optional.empty();
			}
		};
		var SUT = new HelloService(mockRepository);
		//when
		var result = SUT.prepareGreeting(null,"-1");
		//then
		assertThat(result).isEqualTo(HelloService.FALLBACK_LANG.getWelcomeMsg()+" "+HelloService.FALLBACK_NAME+"!");
	}

	private LangRepository fallBackLangIdRepository() {
		var mockRepository = new LangRepository(){
			@Override
			Optional<Lang> findById(Integer id) {
				if(id.equals(HelloService.FALLBACK_LANG.getId())){
					return Optional.of(new Lang(null,FALLBACK_ID_WELCOME,null));
				}
				return Optional.empty();
			}
		};
		return mockRepository;
	}

	private LangRepository alwaysReturningHelloRepository() {
		var mockRepository = new LangRepository(){
			@Override
			Optional<Lang> findById(Integer id) {
				return Optional.of(new Lang(null,WELCOME,null));
			}
		};
		return mockRepository;
	}
}