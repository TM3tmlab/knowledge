package org.support.project.knowledge.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.support.project.common.exception.ParseException;
import org.support.project.common.log.Log;
import org.support.project.common.log.LogFactory;
import org.support.project.common.test.Order;
import org.support.project.common.test.OrderedRunner;
import org.support.project.common.util.FileUtil;
import org.support.project.knowledge.TestCommon;
import org.support.project.web.logic.SanitizingLogic;

@RunWith(OrderedRunner.class)
public class MarkdownLogicTest extends TestCommon {
    /** ログ */
    private static final Log LOG = LogFactory.getLog(MarkdownLogicTest.class);

    /**
     * 改行コードは無視して値比較をするために、文字列（Line）の配列で取得
     * 
     * @param str
     * @return
     * @throws IOException
     */
    private String[] read(String str) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new StringReader(str));
            List<String> list = new ArrayList<String>();
            String s;
            while ((s = reader.readLine()) != null) {
                list.add(s);
            }
            return list.toArray(new String[0]);
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

    }

    @Test
    @Order(order = 1)
    public void test1() throws Exception {
        String markdown = FileUtil.read(getClass().getResourceAsStream("markdown/markdown-1.md"));
        String html = FileUtil.read(getClass().getResourceAsStream("markdown/result-1.txt"));
        String result = MarkdownLogic.get().markdownToHtml(markdown, MarkdownLogic.ENGINE_PEGDOWN).getHtml();
        try {
            org.junit.Assert.assertArrayEquals(read(html), read(result));
        } catch (AssertionError e) {
            LOG.info("test1");
            LOG.info("[Markdown] : " + markdown);
            LOG.info("[Html]     : " + html);
            LOG.info("[Parsed]   : " + result);
            LOG.info("[Indent]   : " + SanitizingLogic.get().indent(result));
            throw e;
        }
    }

    @Test
    @Order(order = 2)
    public void test2() throws UnsupportedEncodingException, IOException, ParseException, TransformerFactoryConfigurationError, TransformerException {
        String markdown = FileUtil.read(getClass().getResourceAsStream("markdown/markdown-2.md"));
        String html = FileUtil.read(getClass().getResourceAsStream("markdown/result-2.txt"));
        String result = MarkdownLogic.get().markdownToHtml(markdown, MarkdownLogic.ENGINE_PEGDOWN).getHtml();
        try {
            org.junit.Assert.assertArrayEquals(read(html), read(result));
        } catch (AssertionError e) {
            LOG.info("test2");
            LOG.info("[Markdown] : " + markdown);
            LOG.info("[Html]     : " + html);
            LOG.info("[Parsed]   : " + result);
            LOG.info("[Indent]   : " + SanitizingLogic.get().indent(result));
            throw e;
        }
    }

    @Test
    @Order(order = 3)
    public void test3() throws ParseException, UnsupportedEncodingException, IOException, TransformerFactoryConfigurationError, TransformerException {
        String markdown = FileUtil.read(getClass().getResourceAsStream("markdown/markdown-3.md"));
        String html = FileUtil.read(getClass().getResourceAsStream("markdown/result-3.txt"));
        String result = MarkdownLogic.get().markdownToHtml(markdown, MarkdownLogic.ENGINE_PEGDOWN).getHtml();
        try {
            org.junit.Assert.assertArrayEquals(read(html), read(result));
        } catch (AssertionError e) {
            LOG.info("test3");
            LOG.info("[Markdown] : " + markdown);
            LOG.info("[Html]     : " + html);
            LOG.info("[Parsed]   : " + result);
            LOG.info("[Indent]   : " + SanitizingLogic.get().indent(result));
            throw e;
        }
    }

    @Test
    @Order(order = 4)
    public void test4() throws ParseException, UnsupportedEncodingException, IOException, TransformerFactoryConfigurationError, TransformerException {
        String markdown = FileUtil.read(getClass().getResourceAsStream("markdown/markdown-4.md"));
        String html = FileUtil.read(getClass().getResourceAsStream("markdown/result-4.txt"));
        String result = MarkdownLogic.get().markdownToHtml(markdown, MarkdownLogic.ENGINE_PEGDOWN).getHtml();
        try {
            org.junit.Assert.assertArrayEquals(read(html), read(result));
        } catch (AssertionError e) {
            LOG.info("test4");
            LOG.info("[Markdown] : " + markdown);
            LOG.info("[Html]     : " + html);
            LOG.info("[Parsed]   : " + result);
            LOG.info("[Indent]   : " + SanitizingLogic.get().indent(result));
            throw e;
        }
    }

    @Test
    @Order(order = 5)
    public void test5() throws ParseException, UnsupportedEncodingException, IOException, TransformerFactoryConfigurationError, TransformerException {
        String markdown = FileUtil.read(getClass().getResourceAsStream("markdown/markdown-5.md"));
        String html = FileUtil.read(getClass().getResourceAsStream("markdown/result-5.txt"));
        String result = MarkdownLogic.get().markdownToHtml(markdown, MarkdownLogic.ENGINE_PEGDOWN).getHtml();
        try {
            org.junit.Assert.assertArrayEquals(read(html), read(result));
        } catch (AssertionError e) {
            LOG.info("test5");
            LOG.info("[Markdown] : " + markdown);
            LOG.info("[Html]     : " + html);
            LOG.info("[Parsed]   : " + result);
            LOG.info("[Indent]   : " + SanitizingLogic.get().indent(result));
            throw e;
        }
    }

    @Test
    @Order(order = 6)
    public void test6() throws ParseException, UnsupportedEncodingException, IOException, TransformerFactoryConfigurationError, TransformerException {
        String markdown = FileUtil.read(getClass().getResourceAsStream("markdown/markdown-6.md"));
        String html = FileUtil.read(getClass().getResourceAsStream("markdown/result-6.txt"));
        String result = MarkdownLogic.get().markdownToHtml(markdown, MarkdownLogic.ENGINE_MARKEDJS).getHtml();
        try {
            org.junit.Assert.assertArrayEquals(read(html), read(result));
        } catch (AssertionError e) {
            LOG.info("test6");
            LOG.info("[Markdown] : " + markdown);
            LOG.info("[Html]     : " + html);
            LOG.info("[Parsed]   : " + result);
            LOG.info("[Indent]   : " + SanitizingLogic.get().indent(result));
            throw e;
        }

        markdown = FileUtil.read(getClass().getResourceAsStream("markdown/markdown-6-2.md"));
        html = FileUtil.read(getClass().getResourceAsStream("markdown/result-6-2.txt"));
        result = MarkdownLogic.get().markdownToHtml(markdown, MarkdownLogic.ENGINE_MARKEDJS).getHtml();
        try {
            org.junit.Assert.assertArrayEquals(read(html), read(result));
        } catch (AssertionError e) {
            LOG.info("test6-2");
            LOG.info("[Markdown] : " + markdown);
            LOG.info("[Html]     : " + html);
            LOG.info("[Parsed]   : " + result);
            LOG.info("[Indent]   : " + SanitizingLogic.get().indent(result));
            throw e;
        }
        markdown = FileUtil.read(getClass().getResourceAsStream("markdown/markdown-6-2.md"));
        html = FileUtil.read(getClass().getResourceAsStream("markdown/result-6-2.txt"));
        result = MarkdownLogic.get().markdownToHtml(markdown, MarkdownLogic.ENGINE_MARKEDJS).getHtml();
        try {
            org.junit.Assert.assertArrayEquals(read(html), read(result));
        } catch (AssertionError e) {
            LOG.info("test5");
            LOG.info("[Markdown] : " + markdown);
            LOG.info("[Html]     : " + html);
            LOG.info("[Parsed]   : " + result);
            LOG.info("[Indent]   : " + SanitizingLogic.get().indent(result));
            throw e;
        }
    }

    @Test
    @Order(order = 7)
    public void testMarkdJ1()
            throws ParseException, UnsupportedEncodingException, IOException, TransformerFactoryConfigurationError, TransformerException {
        String markdown = FileUtil.read(getClass().getResourceAsStream("markdown/markdj-1.md"));
        String html = FileUtil.read(getClass().getResourceAsStream("markdown/result-markdj-1.txt"));
        String result = MarkdownLogic.get().markdownToHtml(markdown, MarkdownLogic.ENGINE_MARKEDJ).getHtml();
        try {
            org.junit.Assert.assertArrayEquals(read(html), read(result));
        } catch (AssertionError e) {
            LOG.info("testMarkdJ1");
            LOG.info("[Markdown] : " + markdown);
            LOG.info("[Html]     : " + html);
            LOG.info("[Parsed]   : " + result);
            LOG.info("[Indent]   : " + SanitizingLogic.get().indent(result));
            throw e;
        }
    }

    @Test
    @Order(order = 8)
    public void testMarkdJLink()
            throws ParseException, UnsupportedEncodingException, IOException, TransformerFactoryConfigurationError, TransformerException {
        String markdown = FileUtil.read(getClass().getResourceAsStream("markdown/markdj-link.md"));
        String html = FileUtil.read(getClass().getResourceAsStream("markdown/result-markdj-link.txt"));
        String result = MarkdownLogic.get().markdownToHtml(markdown, MarkdownLogic.ENGINE_MARKEDJ).getHtml();
        try {
            org.junit.Assert.assertArrayEquals(read(html), read(result));
        } catch (AssertionError e) {
            LOG.info("testMarkdJ1");
            LOG.info("[Markdown] : " + markdown);
            LOG.info("[Html]     : " + html);
            LOG.info("[Parsed]   : " + result);
            LOG.info("[Indent]   : " + SanitizingLogic.get().indent(result));
            throw e;
        }
    }

    @Test
    @Order(order = 8)
    public void testMarkdJDel()
            throws ParseException, UnsupportedEncodingException, IOException, TransformerFactoryConfigurationError, TransformerException {
        String markdown = FileUtil.read(getClass().getResourceAsStream("markdown/markdj-del.md"));
        String html = FileUtil.read(getClass().getResourceAsStream("markdown/result-markdj-del.txt"));
        String result = MarkdownLogic.get().markdownToHtml(markdown, MarkdownLogic.ENGINE_MARKEDJ).getHtml();
        try {
            org.junit.Assert.assertArrayEquals(read(html), read(result));
        } catch (AssertionError e) {
            LOG.info("testMarkdJDel");
            LOG.info("[Markdown] : " + markdown);
            LOG.info("[Html]     : " + html);
            LOG.info("[Parsed]   : " + result);
            LOG.info("[Indent]   : " + SanitizingLogic.get().indent(result));
            throw e;
        }
    }

    

    @Test
    @Order(order = 9)
    public void testUNC()
            throws ParseException, UnsupportedEncodingException, IOException, TransformerFactoryConfigurationError, TransformerException {
        String markdown = "[UNCPathLink](\\\\hoge\\data, \"UNCPathLink\")";
        String html = "<p><a href=\"\\\\hoge\\data,\" title=\"UNCPathLink\" rel=\"nofollow\">UNCPathLink</a></p>\n";
        String result = MarkdownLogic.get().markdownToHtml(markdown, MarkdownLogic.ENGINE_MARKEDJ).getHtml();
        try {
            org.junit.Assert.assertEquals(html, result);
        } catch (AssertionError e) {
            LOG.info("testMarkdJDel");
            LOG.info("[Markdown] : " + markdown);
            LOG.info("[Html]     : " + html);
            LOG.info("[Parsed]   : " + result);
            LOG.info("[Indent]   : " + SanitizingLogic.get().indent(result));
            throw e;
        }
    }
    

    
    @Test
    @Order(order = 10)
    public void testAmp()
            throws ParseException, UnsupportedEncodingException, IOException, TransformerFactoryConfigurationError, TransformerException {
        String markdown = "```\n&read_data\n```";
        String html = "<pre><code class=\"hljs\">&amp;read_data\n</code></pre>\n";
        String result = MarkdownLogic.get().markdownToHtml(markdown, MarkdownLogic.ENGINE_MARKEDJ).getHtml();
        try {
            org.junit.Assert.assertEquals(html, result);
        } catch (AssertionError e) {
            LOG.info("testMarkdJDel");
            LOG.info("[Markdown] : " + markdown);
            LOG.info("[Html]     : " + html);
            LOG.info("[Parsed]   : " + result);
            LOG.info("[Indent]   : " + SanitizingLogic.get().indent(result));
            throw e;
        }
    }
    
    
    
}
