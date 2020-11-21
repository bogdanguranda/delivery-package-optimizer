package com.bogdanguranda.deliverypackageoptimizer.parser;

import java.util.List;

public interface FileParser {
    List<TestCase> parse(String fileName);
}
