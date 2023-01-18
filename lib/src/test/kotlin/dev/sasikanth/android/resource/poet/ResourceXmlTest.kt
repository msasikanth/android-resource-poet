package dev.sasikanth.android.resource.poet

import com.google.common.truth.Truth.assertThat
import kotlin.test.Test

class ResourceXmlTest {

    @Test fun emptyResourcesXmlShouldBeGeneratedCorrectly() {
        // given
        val expectedResourceXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <resources/>

        """.trimIndent()

        // when
        val resourceXml = resourceXml {
            // no-op
        }

        // then
        assertThat(resourceXml).isEqualTo(expectedResourceXml)
    }
}
