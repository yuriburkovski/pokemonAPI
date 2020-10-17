package pl.sdaacademy.PokemonAcademyApi.demo.paging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestController {

    @Autowired
    private TestRepository testRepository;

    private List<String> items =
            Arrays.asList("a", "b", "c", "d", "aa", "bb", "cc", "dd", "aaa", "bbb", "ccc", "ddd");

    @PostConstruct
    public void save() {
        List<Test> tests = items.stream().map(Test::new).collect(Collectors.toList());
        testRepository.saveAll(tests);
    }

    @GetMapping
    public List<Test> testPagination(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Test> items = testRepository.findAll(pageable);
        return items.get().collect(Collectors.toList());
    }
}