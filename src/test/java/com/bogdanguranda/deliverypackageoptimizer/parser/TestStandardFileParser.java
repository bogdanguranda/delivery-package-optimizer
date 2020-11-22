package com.bogdanguranda.deliverypackageoptimizer.parser;

import com.bogdanguranda.deliverypackageoptimizer.exceptions.InvalidFileFormatException;
import com.bogdanguranda.deliverypackageoptimizer.model.Item;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.*;

public class TestStandardFileParser {

    private static final String TEST_RESOURCES_PATH = "src/test/resources/";
    private FileParser fileParser = new StandardFileParser();

    /**
     * Test that if the given file does not exist a FileNotFoundException exception is thrown.
     */
    @Test(expected = FileNotFoundException.class)
    public void testFileMissingThrowsFileNotFoundException() throws FileNotFoundException, InvalidFileFormatException {
        fileParser.parse(TEST_RESOURCES_PATH + "nonExistentFile.txt");
    }

    /**
     * Test that if the given file is empty an InvalidFileContentException exception is thrown.
     */
    @Test(expected = InvalidFileFormatException.class)
    public void testEmptyFileThrowsInvalidFileContentException() throws FileNotFoundException, InvalidFileFormatException {
        fileParser.parse(TEST_RESOURCES_PATH + "emptyFile.txt");
    }

    /**
     * Test that if the given file is having a wrong format an InvalidFileContentException exception is thrown.
     */
    @Test(expected = InvalidFileFormatException.class)
    public void testWrongFileFormatThrowsInvalidFileContentException() throws FileNotFoundException, InvalidFileFormatException {
        fileParser.parse(TEST_RESOURCES_PATH + "wrongFormatFile.txt");
    }

    /**
     * Test that if the given file is in the right format the uses cases are parsed well.
     */
    @Test
    public void testOKFileIsParsedCorrectly() throws FileNotFoundException, InvalidFileFormatException {
        List<UseCase> parsedUseCases = fileParser.parse(TEST_RESOURCES_PATH + "rightFormatFile.txt");

        assertNotNull(parsedUseCases);
        assertEquals(2, parsedUseCases.size());

        UseCase firstUseCase = parsedUseCases.get(0);
        assertNotNull(firstUseCase);
        assertEquals(81, firstUseCase.getWeightLimit(), 0.0);
        assertEquals(3, firstUseCase.getAllItems().size());

        Item firstUseCaseItem1 = firstUseCase.getAllItems().get(0);
        assertEquals(1, (int) firstUseCaseItem1.getId());
        assertEquals(53.38, firstUseCaseItem1.getWeight(), 0.0);
        assertEquals(45, (int) firstUseCaseItem1.getCost());

        Item firstUseCaseItem2 = firstUseCase.getAllItems().get(1);
        assertEquals(2, (int) firstUseCaseItem2.getId());
        assertEquals(88.62, firstUseCaseItem2.getWeight(), 0.0);
        assertEquals(98, (int) firstUseCaseItem2.getCost());

        Item firstUseCaseItem3 = firstUseCase.getAllItems().get(2);
        assertEquals(3, (int) firstUseCaseItem3.getId());
        assertEquals(78.48, firstUseCaseItem3.getWeight(), 0.0);
        assertEquals(3, (int) firstUseCaseItem3.getCost());

        UseCase secondUseCase = parsedUseCases.get(1);
        assertNotEquals(null, secondUseCase);
        assertEquals(8, secondUseCase.getWeightLimit(), 0.0);
        assertEquals(1, secondUseCase.getAllItems().size());

        Item secondUseCaseItem1 = secondUseCase.getAllItems().get(0);
        assertEquals(1, (int) secondUseCaseItem1.getId());
        assertEquals(15.3, secondUseCaseItem1.getWeight(), 0.0);
        assertEquals(34, (int) secondUseCaseItem1.getCost());
    }
}