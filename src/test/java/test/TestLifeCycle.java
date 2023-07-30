package test;

import org.junit.jupiter.api.*;

public class TestLifeCycle {

    @BeforeAll
    static void beforeAll() {
        System.out.println("## beforeAll Annotation 호출 ##");
        System.out.println();
    }
    @AfterAll
    static void afterAll() {
        System.out.println("## afterAll Annotation 호출 ##");
        System.out.println();
    }
    @BeforeEach
    void beforeEach() {
        System.out.println("## beforeEach Annotation 호출 ##");
        System.out.println();
    }
    @AfterEach
    void afterEach() {
        System.out.println("## afterEach Annotation 호출 ##");
        System.out.println();
    }
    @Test
    void test1() {
        System.out.println("## test1 시작 ##");
        System.out.println();
    }

    @Test
    @DisplayName("Test Case 2 !!!!") // Test Run 실행 시, 보여지는 메소드명을 다르게 노출.
    void test2() {
        System.out.println("## test2 시작 ##");
        System.out.println();
    }

    @Test
    @Disabled // Disabled Annotation : 테스트를 실행하지 않게 설정한 어노테이션
    void test3() {
        System.out.println("## test3 시작 ##");
        System.out.println();
    }
}
