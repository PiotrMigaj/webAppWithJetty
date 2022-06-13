package io.github.mat3e;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HelloServiceTest {

	private HelloService SUT;

	@BeforeEach
	void setUp() {
		this.SUT = new HelloService();
	}

	@Test
	void nullPrepareGreetingReturnsFallbackValue() {
		//given
		String name = null;
		String expectedResult = "Hello " + HelloService.FALLBACK_NAME;
		//when
		String result = this.SUT.prepareGreeting(name);
		//then
		assertThat(result).isEqualTo(expectedResult);
	}

	@Test
	void namePrepareGreetingReturnsGreetingWithName () {
		//given
		String name = "Piotr";
		String expectedResult = "Hello " + name;
		//when
		String result = this.SUT.prepareGreeting(name);
		//then
		assertThat(result).isEqualTo(expectedResult);
	}
}