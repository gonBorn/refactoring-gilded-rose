package com.gildedrose;

import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GildedRoseSafetyNetTest {
    @Test
    public void should_generate_output() throws IOException {
        String baseline = Files.toString(new File("src/test/java/com/gildedrose/baseline.txt"), UTF_8);
        assertThat(TexttestFixture.generateOutput(), is(baseline));
    }
}
