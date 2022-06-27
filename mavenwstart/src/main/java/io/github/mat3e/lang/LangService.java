package io.github.mat3e.lang;

import java.util.List;

import static java.util.stream.Collectors.toList;

class LangService {

	private LangRepository repository;

	LangService() {
		this(new LangRepository());
	}

	LangService(LangRepository langRepository) {
		this.repository = langRepository;
	}

	List<LangDTO> findAll() {
		return repository.findAll()
				.stream()
				.map(LangDTO::new)
				.collect(toList());
	}

}
