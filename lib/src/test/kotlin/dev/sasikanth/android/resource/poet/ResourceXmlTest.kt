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

    @Test fun stringResourceXmlShouldBeGeneratedCorrectly() {
        // given
        val expectedResourceXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <resources>
            <string name="hello">Hello!</string>
        </resources>

        """.trimIndent()

        // when
        val resourceXml = resourceXml {
            string {
                name = "hello"
                value = "Hello!"
            }
        }

        // then
        assertThat(resourceXml).isEqualTo(expectedResourceXml)
    }

    @Test fun untranslatableStringResourceXmlShouldBeGeneratedCorrectly() {
        // given
        val expectedResourceXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <resources>
            <string name="app_name" translatable="false">Twine</string>
        </resources>

        """.trimIndent()

        // when
        val resourceXml = resourceXml {
            string {
                name = "app_name"
                value = "Twine"
                translatable = false
            }
        }

        // then
        assertThat(resourceXml).isEqualTo(expectedResourceXml)
    }

    @Test fun stringArrayResourceXmlShouldBeGeneratedCorrectly() {
        // given
        val expectedResourceXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <resources>
            <string-array name="planets_array">
                <item>Mercury</item>
                <item>Venus</item>
                <item>Earth</item>
                <item>Mars</item>
            </string-array>
        </resources>

        """.trimIndent()

        // when
        val resourceXml = resourceXml {
            stringArray {
                name = "planets_array"
                items = arrayOf(
                    "Mercury",
                    "Venus",
                    "Earth",
                    "Mars"
                )
            }
        }

        // then
        assertThat(resourceXml).isEqualTo(expectedResourceXml)
    }

    @Test fun untranslatableStringArrayResourceXmlShouldBeGeneratedCorrectly() {
        // given
        val expectedResourceXml = """
        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <resources>
            <string-array name="planets_array" translatable="false">
                <item>Mercury</item>
                <item>Venus</item>
                <item>Earth</item>
                <item>Mars</item>
            </string-array>
        </resources>

    """.trimIndent()

        // when
        val resourceXml = resourceXml {
            stringArray {
                name = "planets_array"
                items = arrayOf(
                    "Mercury",
                    "Venus",
                    "Earth",
                    "Mars"
                )
                translatable = false
            }
        }

        // then
        assertThat(resourceXml).isEqualTo(expectedResourceXml)
    }
}
