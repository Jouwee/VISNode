
package visnode.gui;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import visnode.application.ExceptionHandler;

/**
 * Icon factory
 */
public class IconFactory {

    /** Pattern for Font-Awesome icons */
    private static final Pattern PATTERN_FONT_AWESOME = Pattern.compile("(fa:.*)");
    /** Default color */
    private static final Color DEFAULT_COLOR = new Color(0xDEDEDE);
    /** Default size */
    private static final int DEFAULT_SIZE = 16;
    /** Font for Font-Awesome */
    private Font fontAwesome;
    /** Mapping for UTF-8 chars in vector fonts */
    private final Map<String, String> mapping;
    /** Instance of the factory */
    private static IconFactory instance;

    /**
     * Creates the icon factory
     */
    public IconFactory() {
        try {
            fontAwesome = Font.createFont(Font.TRUETYPE_FONT, IconFactory.class.getResourceAsStream("/fontawesome-webfont.ttf"));
        } catch (Exception e) {
            ExceptionHandler.get().handle(e);
        }
        mapping = loadMapings();
    }
    
    /**
     * Returns the instance for the icon factory
     * 
     * @return IconFactory
     */
    public static IconFactory get() {
        if (instance == null) {
            instance = new IconFactory();
        }
        return instance;
    }
    
    /**
     * Builds an Icon from the key
     * 
     * @param iconKey
     * @return Icon
     */
    public Icon create(String iconKey) {
        Icon icon = null;
        if ((icon = processFontAwesome(iconKey)) != null) {
            return icon;
        }
        throw new IllegalArgumentException("Unable to load icon " + iconKey);
    }

    /**
     * Process Font-Awesome icons
     * 
     * @param iconKey
     * @return Icon
     */
    private Icon processFontAwesome(String iconKey) {
        Matcher matcher = PATTERN_FONT_AWESOME.matcher(iconKey);
        if (!matcher.matches()) {
            return null;
        }
        String name = matcher.group(1);
        return new VectorIcon(fontAwesome, DEFAULT_COLOR, DEFAULT_SIZE, mapping.get(name));
        
    }

    /**
     * Returns the vector font mappings
     * 
     * @return {@code Map<String, String>}
     */
    public Map<String, String> getMapping() {
        return mapping;
    }
    
    /**
     * Load the font mappings
     * 
     * @return Map<String, String>
     */
    private Map<String, String> loadMapings() {
        Map<String, String> map = new HashMap<>();
        map.put("fa:glass", "\uf000");
        map.put("fa:music", "\uf001");
        map.put("fa:search", "\uf002");
        map.put("fa:envelope-o", "\uf003");
        map.put("fa:heart", "\uf004");
        map.put("fa:star", "\uf005");
        map.put("fa:star-o", "\uf006");
        map.put("fa:user", "\uf007");
        map.put("fa:film", "\uf008");
        map.put("fa:th-large", "\uf009");
/*        map.put("fa:th", "\uf00a");*/
        map.put("fa:th-list", "\uf00b");
        map.put("fa:check", "\uf00c");
/*        map.put("fa:remove", "\uf00d");
//        map.put("fa:close", "\uf00d");
//        map.put("fa:times", "\uf00d");*/
        map.put("fa:search-plus", "\uf00e");
        map.put("fa:search-minus", "\uf010");
        map.put("fa:power-off", "\uf011");
        map.put("fa:signal", "\uf012");
        map.put("fa:gear", "\uf013");
        map.put("fa:cog", "\uf013");
        map.put("fa:trash-o", "\uf014");
        map.put("fa:home", "\uf015");
        map.put("fa:file-o", "\uf016");
        map.put("fa:clock-o", "\uf017");
        map.put("fa:road", "\uf018");
        map.put("fa:download", "\uf019");
        map.put("fa:arrow-circle-o-down", "\uf01a");
        map.put("fa:arrow-circle-o-up", "\uf01b");
        map.put("fa:inbox", "\uf01c");
        map.put("fa:play-circle-o", "\uf01d");
        map.put("fa:rotate-right", "\uf01e");
        map.put("fa:repeat", "\uf01e");
        map.put("fa:refresh", "\uf021");
//        map.put("fa:list-alt", "\uf022");
        map.put("fa:lock", "\uf023");
        map.put("fa:flag", "\uf024");
        map.put("fa:headphones", "\uf025");
        map.put("fa:volume-off", "\uf026");
        map.put("fa:volume-down", "\uf027");
        map.put("fa:volume-up", "\uf028");
        map.put("fa:qrcode", "\uf029");
        map.put("fa:barcode", "\uf02a");
        map.put("fa:tag", "\uf02b");
        map.put("fa:tags", "\uf02c");
        map.put("fa:book", "\uf02d");
        map.put("fa:bookmark", "\uf02e");
        map.put("fa:print", "\uf02f");
        map.put("fa:camera", "\uf030");
        map.put("fa:font", "\uf031");
        map.put("fa:bold", "\uf032");
        map.put("fa:italic", "\uf033");
        map.put("fa:text-height", "\uf034");
        map.put("fa:text-width", "\uf035");
        map.put("fa:align-left", "\uf036");
        map.put("fa:align-center", "\uf037");
        map.put("fa:align-right", "\uf038");
        map.put("fa:align-justify", "\uf039");
        map.put("fa:list", "\uf03a");
        map.put("fa:dedent", "\uf03b");
        map.put("fa:outdent", "\uf03b");
        map.put("fa:indent", "\uf03c");
        map.put("fa:video-camera", "\uf03d");
        map.put("fa:photo", "\uf03e");
        map.put("fa:image", "\uf03e");
        map.put("fa:picture-o", "\uf03e");
        map.put("fa:pencil", "\uf040");
        map.put("fa:map-marker", "\uf041");
        map.put("fa:adjust", "\uf042");
        map.put("fa:tint", "\uf043");
        map.put("fa:edit", "\uf044");
        map.put("fa:pencil-square-o", "\uf044");
        map.put("fa:share-square-o", "\uf045");
        map.put("fa:check-square-o", "\uf046");
        map.put("fa:arrows", "\uf047");
        map.put("fa:step-backward", "\uf048");
        map.put("fa:fast-backward", "\uf049");
        map.put("fa:backward", "\uf04a");
        map.put("fa:play", "\uf04b");
        map.put("fa:pause", "\uf04c");
        map.put("fa:stop", "\uf04d");
        map.put("fa:forward", "\uf04e");
        map.put("fa:fast-forward", "\uf050");
        map.put("fa:step-forward", "\uf051");
        map.put("fa:eject", "\uf052");
        map.put("fa:chevron-left", "\uf053");
        map.put("fa:chevron-right", "\uf054");
        map.put("fa:plus-circle", "\uf055");
        map.put("fa:minus-circle", "\uf056");
        map.put("fa:times-circle", "\uf057");
        map.put("fa:check-circle", "\uf058");
        map.put("fa:question-circle", "\uf059");
        map.put("fa:info-circle", "\uf05a");
        map.put("fa:crosshairs", "\uf05b");
//        map.put("fa:times-circle-o", "\uf05c");
        map.put("fa:check-circle-o", "\uf05d");
        map.put("fa:ban", "\uf05e");
        map.put("fa:arrow-left", "\uf060");
        map.put("fa:arrow-right", "\uf061");
        map.put("fa:arrow-up", "\uf062");
        map.put("fa:arrow-down", "\uf063");
        map.put("fa:mail-forward", "\uf064");
        map.put("fa:share", "\uf064");
        map.put("fa:expand", "\uf065");
        map.put("fa:compress", "\uf066");
        map.put("fa:plus", "\uf067");
        map.put("fa:minus", "\uf068");
        map.put("fa:asterisk", "\uf069");
        map.put("fa:exclamation-circle", "\uf06a");
        map.put("fa:gift", "\uf06b");
        map.put("fa:leaf", "\uf06c");
        map.put("fa:fire", "\uf06d");
        map.put("fa:eye", "\uf06e");
        map.put("fa:eye-slash", "\uf070");
        map.put("fa:warning", "\uf071");
        map.put("fa:exclamation-triangle", "\uf071");
        map.put("fa:plane", "\uf072");
        map.put("fa:calendar", "\uf073");
        map.put("fa:random", "\uf074");
        map.put("fa:comment", "\uf075");
        map.put("fa:magnet", "\uf076");
        map.put("fa:chevron-up", "\uf077");
        map.put("fa:chevron-down", "\uf078");
        map.put("fa:retweet", "\uf079");
        map.put("fa:shopping-cart", "\uf07a");
        map.put("fa:folder", "\uf07b");
        map.put("fa:folder-open", "\uf07c");
        map.put("fa:arrows-v", "\uf07d");
        map.put("fa:arrows-h", "\uf07e");
        map.put("fa:bar-chart-o", "\uf080");
        map.put("fa:bar-chart", "\uf080");
        map.put("fa:twitter-square", "\uf081");
        map.put("fa:facebook-square", "\uf082");
        map.put("fa:camera-retro", "\uf083");
        map.put("fa:key", "\uf084");
        map.put("fa:gears", "\uf085");
        map.put("fa:cogs", "\uf085");
        map.put("fa:comments", "\uf086");
        map.put("fa:thumbs-o-up", "\uf087");
        map.put("fa:thumbs-o-down", "\uf088");
        map.put("fa:star-half", "\uf089");
        map.put("fa:heart-o", "\uf08a");
        map.put("fa:sign-out", "\uf08b");
        map.put("fa:linkedin-square", "\uf08c");
        map.put("fa:thumb-tack", "\uf08d");
        map.put("fa:external-link", "\uf08e");
        map.put("fa:sign-in", "\uf090");
        map.put("fa:trophy", "\uf091");
        map.put("fa:github-square", "\uf092");
        map.put("fa:upload", "\uf093");
        map.put("fa:lemon-o", "\uf094");
        map.put("fa:phone", "\uf095");
        map.put("fa:square-o", "\uf096");
        map.put("fa:bookmark-o", "\uf097");
        map.put("fa:phone-square", "\uf098");
        map.put("fa:twitter", "\uf099");
        map.put("fa:facebook-f", "\uf09a");
        map.put("fa:facebook", "\uf09a");
        map.put("fa:github", "\uf09b");
        map.put("fa:unlock", "\uf09c");
        map.put("fa:credit-card", "\uf09d");
        map.put("fa:feed", "\uf09e");
        map.put("fa:rss", "\uf09e");
        map.put("fa:hdd-o", "\uf0a0");
        map.put("fa:bullhorn", "\uf0a1");
        map.put("fa:bell", "\uf0f3");
        map.put("fa:certificate", "\uf0a3");
        map.put("fa:hand-o-right", "\uf0a4");
        map.put("fa:hand-o-left", "\uf0a5");
        map.put("fa:hand-o-up", "\uf0a6");
        map.put("fa:hand-o-down", "\uf0a7");
        map.put("fa:arrow-circle-left", "\uf0a8");
        map.put("fa:arrow-circle-right", "\uf0a9");
        map.put("fa:arrow-circle-up", "\uf0aa");
        map.put("fa:arrow-circle-down", "\uf0ab");
        map.put("fa:globe", "\uf0ac");
        map.put("fa:wrench", "\uf0ad");
        map.put("fa:tasks", "\uf0ae");
        map.put("fa:filter", "\uf0b0");
        map.put("fa:briefcase", "\uf0b1");
        map.put("fa:arrows-alt", "\uf0b2");
        map.put("fa:group", "\uf0c0");
        map.put("fa:users", "\uf0c0");
        map.put("fa:chain", "\uf0c1");
        map.put("fa:link", "\uf0c1");
        map.put("fa:cloud", "\uf0c2");
        map.put("fa:flask", "\uf0c3");
        map.put("fa:cut", "\uf0c4");
        map.put("fa:scissors", "\uf0c4");
        map.put("fa:copy", "\uf0c5");
        map.put("fa:files-o", "\uf0c5");
        map.put("fa:paperclip", "\uf0c6");
        map.put("fa:save", "\uf0c7");
        map.put("fa:floppy-o", "\uf0c7");
        map.put("fa:square", "\uf0c8");
        map.put("fa:navicon", "\uf0c9");
        map.put("fa:reorder", "\uf0c9");
        map.put("fa:bars", "\uf0c9");
        map.put("fa:list-ul", "\uf0ca");
        map.put("fa:list-ol", "\uf0cb");
        map.put("fa:strikethrough", "\uf0cc");
        map.put("fa:underline", "\uf0cd");
        map.put("fa:table", "\uf0ce");
        map.put("fa:magic", "\uf0d0");
        map.put("fa:truck", "\uf0d1");
        map.put("fa:pinterest", "\uf0d2");
        map.put("fa:pinterest-square", "\uf0d3");
        map.put("fa:google-plus-square", "\uf0d4");
        map.put("fa:google-plus", "\uf0d5");
        map.put("fa:money", "\uf0d6");
        map.put("fa:caret-down", "\uf0d7");
        map.put("fa:caret-up", "\uf0d8");
        map.put("fa:caret-left", "\uf0d9");
        map.put("fa:caret-right", "\uf0da");
        map.put("fa:columns", "\uf0db");
        map.put("fa:unsorted", "\uf0dc");
        map.put("fa:sort", "\uf0dc");
        map.put("fa:sort-down", "\uf0dd");
        map.put("fa:sort-desc", "\uf0dd");
        map.put("fa:sort-up", "\uf0de");
        map.put("fa:sort-asc", "\uf0de");
        map.put("fa:envelope", "\uf0e0");
        map.put("fa:linkedin", "\uf0e1");
        map.put("fa:rotate-left", "\uf0e2");
        map.put("fa:undo", "\uf0e2");
        map.put("fa:legal", "\uf0e3");
        map.put("fa:gavel", "\uf0e3");
        map.put("fa:dashboard", "\uf0e4");
        map.put("fa:tachometer", "\uf0e4");
        map.put("fa:comment-o", "\uf0e5");
        map.put("fa:comments-o", "\uf0e6");
        map.put("fa:flash", "\uf0e7");
        map.put("fa:bolt", "\uf0e7");
        map.put("fa:sitemap", "\uf0e8");
        map.put("fa:umbrella", "\uf0e9");
        map.put("fa:paste", "\uf0ea");
        map.put("fa:clipboard", "\uf0ea");
        map.put("fa:lightbulb-o", "\uf0eb");
        map.put("fa:exchange", "\uf0ec");
        map.put("fa:cloud-download", "\uf0ed");
        map.put("fa:cloud-upload", "\uf0ee");
        map.put("fa:user-md", "\uf0f0");
        map.put("fa:stethoscope", "\uf0f1");
        map.put("fa:suitcase", "\uf0f2");
        map.put("fa:bell-o", "\uf0a2");
        map.put("fa:coffee", "\uf0f4");
        map.put("fa:cutlery", "\uf0f5");
        map.put("fa:file-text-o", "\uf0f6");
        map.put("fa:building-o", "\uf0f7");
        map.put("fa:hospital-o", "\uf0f8");
        map.put("fa:ambulance", "\uf0f9");
        map.put("fa:medkit", "\uf0fa");
        map.put("fa:fighter-jet", "\uf0fb");
        map.put("fa:beer", "\uf0fc");
        map.put("fa:h-square", "\uf0fd");
        map.put("fa:plus-square", "\uf0fe");
        map.put("fa:angle-double-left", "\uf100");
        map.put("fa:angle-double-right", "\uf101");
        map.put("fa:angle-double-up", "\uf102");
        map.put("fa:angle-double-down", "\uf103");
        map.put("fa:angle-left", "\uf104");
        map.put("fa:angle-right", "\uf105");
        map.put("fa:angle-up", "\uf106");
        map.put("fa:angle-down", "\uf107");
        map.put("fa:desktop", "\uf108");
        map.put("fa:laptop", "\uf109");
        map.put("fa:tablet", "\uf10a");
        map.put("fa:mobile-phone", "\uf10b");
        map.put("fa:mobile", "\uf10b");
        map.put("fa:circle-o", "\uf10c");
        map.put("fa:quote-left", "\uf10d");
        map.put("fa:quote-right", "\uf10e");
        map.put("fa:spinner", "\uf110");
        map.put("fa:circle", "\uf111");
        map.put("fa:mail-reply", "\uf112");
        map.put("fa:reply", "\uf112");
        map.put("fa:github-alt", "\uf113");
        map.put("fa:folder-o", "\uf114");
        map.put("fa:folder-open-o", "\uf115");
        map.put("fa:smile-o", "\uf118");
        map.put("fa:frown-o", "\uf119");
        map.put("fa:meh-o", "\uf11a");
        map.put("fa:gamepad", "\uf11b");
        map.put("fa:keyboard-o", "\uf11c");
        map.put("fa:flag-o", "\uf11d");
        map.put("fa:flag-checkered", "\uf11e");
        map.put("fa:terminal", "\uf120");
        map.put("fa:code", "\uf121");
        map.put("fa:mail-reply-all", "\uf122");
        map.put("fa:reply-all", "\uf122");
        map.put("fa:star-half-empty", "\uf123");
        map.put("fa:star-half-full", "\uf123");
        map.put("fa:star-half-o", "\uf123");
        map.put("fa:location-arrow", "\uf124");
        map.put("fa:crop", "\uf125");
        map.put("fa:code-fork", "\uf126");
        map.put("fa:unlink", "\uf127");
        map.put("fa:chain-broken", "\uf127");
        map.put("fa:question", "\uf128");
        map.put("fa:info", "\uf129");
        map.put("fa:exclamation", "\uf12a");
        map.put("fa:superscript", "\uf12b");
        map.put("fa:subscript", "\uf12c");
        map.put("fa:eraser", "\uf12d");
        map.put("fa:puzzle-piece", "\uf12e");
        map.put("fa:microphone", "\uf130");
        map.put("fa:microphone-slash", "\uf131");
        map.put("fa:shield", "\uf132");
        map.put("fa:calendar-o", "\uf133");
        map.put("fa:fire-extinguisher", "\uf134");
        map.put("fa:rocket", "\uf135");
        map.put("fa:maxcdn", "\uf136");
        map.put("fa:chevron-circle-left", "\uf137");
        map.put("fa:chevron-circle-right", "\uf138");
        map.put("fa:chevron-circle-up", "\uf139");
        map.put("fa:chevron-circle-down", "\uf13a");
        map.put("fa:html5", "\uf13b");
        map.put("fa:css3", "\uf13c");
        map.put("fa:anchor", "\uf13d");
        map.put("fa:unlock-alt", "\uf13e");
        map.put("fa:bullseye", "\uf140");
        map.put("fa:ellipsis-h", "\uf141");
        map.put("fa:ellipsis-v", "\uf142");
        map.put("fa:rss-square", "\uf143");
        map.put("fa:play-circle", "\uf144");
        map.put("fa:ticket", "\uf145");
        map.put("fa:minus-square", "\uf146");
        map.put("fa:minus-square-o", "\uf147");
        map.put("fa:level-up", "\uf148");
        map.put("fa:level-down", "\uf149");
        map.put("fa:check-square", "\uf14a");
        map.put("fa:pencil-square", "\uf14b");
        map.put("fa:external-link-square", "\uf14c");
        map.put("fa:share-square", "\uf14d");
        map.put("fa:compass", "\uf14e");
        map.put("fa:toggle-down", "\uf150");
        map.put("fa:caret-square-o-down", "\uf150");
        map.put("fa:toggle-up", "\uf151");
        map.put("fa:caret-square-o-up", "\uf151");
        map.put("fa:toggle-right", "\uf152");
        map.put("fa:caret-square-o-right", "\uf152");
        map.put("fa:euro", "\uf153");
        map.put("fa:eur", "\uf153");
        map.put("fa:gbp", "\uf154");
        map.put("fa:dollar", "\uf155");
        map.put("fa:usd", "\uf155");
        map.put("fa:rupee", "\uf156");
        map.put("fa:inr", "\uf156");
        map.put("fa:cny", "\uf157");
        map.put("fa:rmb", "\uf157");
        map.put("fa:yen", "\uf157");
        map.put("fa:jpy", "\uf157");
        map.put("fa:ruble", "\uf158");
        map.put("fa:rouble", "\uf158");
        map.put("fa:rub", "\uf158");
        map.put("fa:won", "\uf159");
        map.put("fa:krw", "\uf159");
        map.put("fa:bitcoin", "\uf15a");
        map.put("fa:btc", "\uf15a");
        map.put("fa:file", "\uf15b");
        map.put("fa:file-text", "\uf15c");
        map.put("fa:sort-alpha-asc", "\uf15d");
        map.put("fa:sort-alpha-desc", "\uf15e");
        map.put("fa:sort-amount-asc", "\uf160");
        map.put("fa:sort-amount-desc", "\uf161");
        map.put("fa:sort-numeric-asc", "\uf162");
        map.put("fa:sort-numeric-desc", "\uf163");
        map.put("fa:thumbs-up", "\uf164");
        map.put("fa:thumbs-down", "\uf165");
        map.put("fa:youtube-square", "\uf166");
        map.put("fa:youtube", "\uf167");
        map.put("fa:xing", "\uf168");
        map.put("fa:xing-square", "\uf169");
        map.put("fa:youtube-play", "\uf16a");
        map.put("fa:dropbox", "\uf16b");
        map.put("fa:stack-overflow", "\uf16c");
        map.put("fa:instagram", "\uf16d");
        map.put("fa:flickr", "\uf16e");
        map.put("fa:adn", "\uf170");
        map.put("fa:bitbucket", "\uf171");
        map.put("fa:bitbucket-square", "\uf172");
        map.put("fa:tumblr", "\uf173");
        map.put("fa:tumblr-square", "\uf174");
        map.put("fa:long-arrow-down", "\uf175");
        map.put("fa:long-arrow-up", "\uf176");
        map.put("fa:long-arrow-left", "\uf177");
        map.put("fa:long-arrow-right", "\uf178");
        map.put("fa:apple", "\uf179");
        map.put("fa:windows", "\uf17a");
        map.put("fa:android", "\uf17b");
        map.put("fa:linux", "\uf17c");
        map.put("fa:dribbble", "\uf17d");
        map.put("fa:skype", "\uf17e");
        map.put("fa:foursquare", "\uf180");
        map.put("fa:trello", "\uf181");
        map.put("fa:female", "\uf182");
        map.put("fa:male", "\uf183");
        map.put("fa:gittip", "\uf184");
        map.put("fa:gratipay", "\uf184");
        map.put("fa:sun-o", "\uf185");
        map.put("fa:moon-o", "\uf186");
        map.put("fa:archive", "\uf187");
        map.put("fa:bug", "\uf188");
        map.put("fa:vk", "\uf189");
        map.put("fa:weibo", "\uf18a");
        map.put("fa:renren", "\uf18b");
        map.put("fa:pagelines", "\uf18c");
        map.put("fa:stack-exchange", "\uf18d");
        map.put("fa:arrow-circle-o-right", "\uf18e");
        map.put("fa:arrow-circle-o-left", "\uf190");
        map.put("fa:toggle-left", "\uf191");
        map.put("fa:caret-square-o-left", "\uf191");
        map.put("fa:dot-circle-o", "\uf192");
        map.put("fa:wheelchair", "\uf193");
        map.put("fa:vimeo-square", "\uf194");
        map.put("fa:turkish-lira", "\uf195");
        map.put("fa:try", "\uf195");
        map.put("fa:plus-square-o", "\uf196");
        map.put("fa:space-shuttle", "\uf197");
        map.put("fa:slack", "\uf198");
        map.put("fa:envelope-square", "\uf199");
        map.put("fa:wordpress", "\uf19a");
        map.put("fa:openid", "\uf19b");
        map.put("fa:institution", "\uf19c");
        map.put("fa:bank", "\uf19c");
        map.put("fa:university", "\uf19c");
        map.put("fa:mortar-board", "\uf19d");
        map.put("fa:graduation-cap", "\uf19d");
        map.put("fa:yahoo", "\uf19e");
        map.put("fa:google", "\uf1a0");
        map.put("fa:reddit", "\uf1a1");
        map.put("fa:reddit-square", "\uf1a2");
        map.put("fa:stumbleupon-circle", "\uf1a3");
        map.put("fa:stumbleupon", "\uf1a4");
        map.put("fa:delicious", "\uf1a5");
        map.put("fa:digg", "\uf1a6");
        map.put("fa:pied-piper-pp", "\uf1a7");
        map.put("fa:pied-piper-alt", "\uf1a8");
        map.put("fa:drupal", "\uf1a9");
        map.put("fa:joomla", "\uf1aa");
        map.put("fa:language", "\uf1ab");
        map.put("fa:fax", "\uf1ac");
        map.put("fa:building", "\uf1ad");
        map.put("fa:child", "\uf1ae");
        map.put("fa:paw", "\uf1b0");
        map.put("fa:spoon", "\uf1b1");
        map.put("fa:cube", "\uf1b2");
        map.put("fa:cubes", "\uf1b3");
        map.put("fa:behance", "\uf1b4");
        map.put("fa:behance-square", "\uf1b5");
        map.put("fa:steam", "\uf1b6");
        map.put("fa:steam-square", "\uf1b7");
        map.put("fa:recycle", "\uf1b8");
        map.put("fa:automobile", "\uf1b9");
        map.put("fa:car", "\uf1b9");
        map.put("fa:cab", "\uf1ba");
        map.put("fa:taxi", "\uf1ba");
        map.put("fa:tree", "\uf1bb");
        map.put("fa:spotify", "\uf1bc");
        map.put("fa:deviantart", "\uf1bd");
        map.put("fa:soundcloud", "\uf1be");
        map.put("fa:database", "\uf1c0");
        map.put("fa:file-pdf-o", "\uf1c1");
        map.put("fa:file-word-o", "\uf1c2");
        map.put("fa:file-excel-o", "\uf1c3");
        map.put("fa:file-powerpoint-o", "\uf1c4");
        map.put("fa:file-photo-o", "\uf1c5");
        map.put("fa:file-picture-o", "\uf1c5");
        map.put("fa:file-image-o", "\uf1c5");
        map.put("fa:file-zip-o", "\uf1c6");
        map.put("fa:file-archive-o", "\uf1c6");
        map.put("fa:file-sound-o", "\uf1c7");
        map.put("fa:file-audio-o", "\uf1c7");
        map.put("fa:file-movie-o", "\uf1c8");
        map.put("fa:file-video-o", "\uf1c8");
        map.put("fa:file-code-o", "\uf1c9");
        map.put("fa:vine", "\uf1ca");
        map.put("fa:codepen", "\uf1cb");
        map.put("fa:jsfiddle", "\uf1cc");
        map.put("fa:life-bouy", "\uf1cd");
        map.put("fa:life-buoy", "\uf1cd");
        map.put("fa:life-saver", "\uf1cd");
        map.put("fa:support", "\uf1cd");
        map.put("fa:life-ring", "\uf1cd");
        map.put("fa:circle-o-notch", "\uf1ce");
        map.put("fa:ra", "\uf1d0");
        map.put("fa:resistance", "\uf1d0");
        map.put("fa:rebel", "\uf1d0");
        map.put("fa:ge", "\uf1d1");
        map.put("fa:empire", "\uf1d1");
        map.put("fa:git-square", "\uf1d2");
        map.put("fa:git", "\uf1d3");
        map.put("fa:y-combinator-square", "\uf1d4");
        map.put("fa:yc-square", "\uf1d4");
        map.put("fa:hacker-news", "\uf1d4");
        map.put("fa:tencent-weibo", "\uf1d5");
        map.put("fa:qq", "\uf1d6");
        map.put("fa:wechat", "\uf1d7");
        map.put("fa:weixin", "\uf1d7");
        map.put("fa:send", "\uf1d8");
        map.put("fa:paper-plane", "\uf1d8");
        map.put("fa:send-o", "\uf1d9");
        map.put("fa:paper-plane-o", "\uf1d9");
        map.put("fa:history", "\uf1da");
        map.put("fa:circle-thin", "\uf1db");
        map.put("fa:header", "\uf1dc");
        map.put("fa:paragraph", "\uf1dd");
        map.put("fa:sliders", "\uf1de");
        map.put("fa:share-alt", "\uf1e0");
        map.put("fa:share-alt-square", "\uf1e1");
        map.put("fa:bomb", "\uf1e2");
        map.put("fa:soccer-ball-o", "\uf1e3");
        map.put("fa:futbol-o", "\uf1e3");
        map.put("fa:tty", "\uf1e4");
        map.put("fa:binoculars", "\uf1e5");
        map.put("fa:plug", "\uf1e6");
        map.put("fa:slideshare", "\uf1e7");
        map.put("fa:twitch", "\uf1e8");
        map.put("fa:yelp", "\uf1e9");
        map.put("fa:newspaper-o", "\uf1ea");
        map.put("fa:wifi", "\uf1eb");
        map.put("fa:calculator", "\uf1ec");
        map.put("fa:paypal", "\uf1ed");
        map.put("fa:google-wallet", "\uf1ee");
        map.put("fa:cc-visa", "\uf1f0");
        map.put("fa:cc-mastercard", "\uf1f1");
        map.put("fa:cc-discover", "\uf1f2");
        map.put("fa:cc-amex", "\uf1f3");
        map.put("fa:cc-paypal", "\uf1f4");
        map.put("fa:cc-stripe", "\uf1f5");
        map.put("fa:bell-slash", "\uf1f6");
        map.put("fa:bell-slash-o", "\uf1f7");
        map.put("fa:trash", "\uf1f8");
        map.put("fa:copyright", "\uf1f9");
        map.put("fa:at", "\uf1fa");
        map.put("fa:eyedropper", "\uf1fb");
        map.put("fa:paint-brush", "\uf1fc");
        map.put("fa:birthday-cake", "\uf1fd");
        map.put("fa:area-chart", "\uf1fe");
        map.put("fa:pie-chart", "\uf200");
        map.put("fa:line-chart", "\uf201");
        map.put("fa:lastfm", "\uf202");
        map.put("fa:lastfm-square", "\uf203");
        map.put("fa:toggle-off", "\uf204");
        map.put("fa:toggle-on", "\uf205");
        map.put("fa:bicycle", "\uf206");
        map.put("fa:bus", "\uf207");
        map.put("fa:ioxhost", "\uf208");
        map.put("fa:angellist", "\uf209");
        map.put("fa:cc", "\uf20a");
        map.put("fa:shekel", "\uf20b");
        map.put("fa:sheqel", "\uf20b");
        map.put("fa:ils", "\uf20b");
        map.put("fa:meanpath", "\uf20c");
        map.put("fa:buysellads", "\uf20d");
        map.put("fa:connectdevelop", "\uf20e");
        map.put("fa:dashcube", "\uf210");
        map.put("fa:forumbee", "\uf211");
        map.put("fa:leanpub", "\uf212");
        map.put("fa:sellsy", "\uf213");
        map.put("fa:shirtsinbulk", "\uf214");
        map.put("fa:simplybuilt", "\uf215");
        map.put("fa:skyatlas", "\uf216");
        map.put("fa:cart-plus", "\uf217");
        map.put("fa:cart-arrow-down", "\uf218");
        map.put("fa:diamond", "\uf219");
        map.put("fa:ship", "\uf21a");
        map.put("fa:user-secret", "\uf21b");
        map.put("fa:motorcycle", "\uf21c");
        map.put("fa:street-view", "\uf21d");
        map.put("fa:heartbeat", "\uf21e");
        map.put("fa:venus", "\uf221");
        map.put("fa:mars", "\uf222");
        map.put("fa:mercury", "\uf223");
        map.put("fa:intersex", "\uf224");
        map.put("fa:transgender", "\uf224");
        map.put("fa:transgender-alt", "\uf225");
        map.put("fa:venus-double", "\uf226");
        map.put("fa:mars-double", "\uf227");
        map.put("fa:venus-mars", "\uf228");
        map.put("fa:mars-stroke", "\uf229");
        map.put("fa:mars-stroke-v", "\uf22a");
        map.put("fa:mars-stroke-h", "\uf22b");
        map.put("fa:neuter", "\uf22c");
        map.put("fa:genderless", "\uf22d");
        map.put("fa:facebook-official", "\uf230");
        map.put("fa:pinterest-p", "\uf231");
        map.put("fa:whatsapp", "\uf232");
        map.put("fa:server", "\uf233");
        map.put("fa:user-plus", "\uf234");
        map.put("fa:user-times", "\uf235");
        map.put("fa:hotel", "\uf236");
        map.put("fa:bed", "\uf236");
        map.put("fa:viacoin", "\uf237");
        map.put("fa:train", "\uf238");
        map.put("fa:subway", "\uf239");
        map.put("fa:medium", "\uf23a");
        map.put("fa:yc", "\uf23b");
        map.put("fa:y-combinator", "\uf23b");
        map.put("fa:optin-monster", "\uf23c");
        map.put("fa:opencart", "\uf23d");
        map.put("fa:expeditedssl", "\uf23e");
        map.put("fa:battery-4", "\uf240");
        map.put("fa:battery", "\uf240");
        map.put("fa:battery-full", "\uf240");
        map.put("fa:battery-3", "\uf241");
        map.put("fa:battery-three-quarters", "\uf241");
        map.put("fa:battery-2", "\uf242");
        map.put("fa:battery-half", "\uf242");
        map.put("fa:battery-1", "\uf243");
        map.put("fa:battery-quarter", "\uf243");
        map.put("fa:battery-0", "\uf244");
        map.put("fa:battery-empty", "\uf244");
        map.put("fa:mouse-pointer", "\uf245");
        map.put("fa:i-cursor", "\uf246");
        map.put("fa:object-group", "\uf247");
        map.put("fa:object-ungroup", "\uf248");
        map.put("fa:sticky-note", "\uf249");
        map.put("fa:sticky-note-o", "\uf24a");
        map.put("fa:cc-jcb", "\uf24b");
        map.put("fa:cc-diners-club", "\uf24c");
        map.put("fa:clone", "\uf24d");
        map.put("fa:balance-scale", "\uf24e");
        map.put("fa:hourglass-o", "\uf250");
        map.put("fa:hourglass-1", "\uf251");
        map.put("fa:hourglass-start", "\uf251");
        map.put("fa:hourglass-2", "\uf252");
        map.put("fa:hourglass-half", "\uf252");
        map.put("fa:hourglass-3", "\uf253");
        map.put("fa:hourglass-end", "\uf253");
        map.put("fa:hourglass", "\uf254");
        map.put("fa:hand-grab-o", "\uf255");
        map.put("fa:hand-rock-o", "\uf255");
        map.put("fa:hand-stop-o", "\uf256");
        map.put("fa:hand-paper-o", "\uf256");
        map.put("fa:hand-scissors-o", "\uf257");
        map.put("fa:hand-lizard-o", "\uf258");
        map.put("fa:hand-spock-o", "\uf259");
        map.put("fa:hand-pointer-o", "\uf25a");
        map.put("fa:hand-peace-o", "\uf25b");
        map.put("fa:trademark", "\uf25c");
        map.put("fa:registered", "\uf25d");
        map.put("fa:creative-commons", "\uf25e");
        map.put("fa:gg", "\uf260");
        map.put("fa:gg-circle", "\uf261");
        map.put("fa:tripadvisor", "\uf262");
        map.put("fa:odnoklassniki", "\uf263");
        map.put("fa:odnoklassniki-square", "\uf264");
        map.put("fa:get-pocket", "\uf265");
        map.put("fa:wikipedia-w", "\uf266");
        map.put("fa:safari", "\uf267");
        map.put("fa:chrome", "\uf268");
        map.put("fa:firefox", "\uf269");
        map.put("fa:opera", "\uf26a");
        map.put("fa:internet-explorer", "\uf26b");
        map.put("fa:tv", "\uf26c");
        map.put("fa:television", "\uf26c");
        map.put("fa:contao", "\uf26d");
        map.put("fa:500px", "\uf26e");
        map.put("fa:amazon", "\uf270");
        map.put("fa:calendar-plus-o", "\uf271");
        map.put("fa:calendar-minus-o", "\uf272");
        map.put("fa:calendar-times-o", "\uf273");
        map.put("fa:calendar-check-o", "\uf274");
        map.put("fa:industry", "\uf275");
        map.put("fa:map-pin", "\uf276");
        map.put("fa:map-signs", "\uf277");
        map.put("fa:map-o", "\uf278");
        map.put("fa:map", "\uf279");
        map.put("fa:commenting", "\uf27a");
        map.put("fa:commenting-o", "\uf27b");
        map.put("fa:houzz", "\uf27c");
        map.put("fa:vimeo", "\uf27d");
        map.put("fa:black-tie", "\uf27e");
        map.put("fa:fonticons", "\uf280");
        map.put("fa:reddit-alien", "\uf281");
        map.put("fa:edge", "\uf282");
        map.put("fa:credit-card-alt", "\uf283");
        map.put("fa:codiepie", "\uf284");
        map.put("fa:modx", "\uf285");
        map.put("fa:fort-awesome", "\uf286");
        map.put("fa:usb", "\uf287");
        map.put("fa:product-hunt", "\uf288");
        map.put("fa:mixcloud", "\uf289");
        map.put("fa:scribd", "\uf28a");
        map.put("fa:pause-circle", "\uf28b");
        map.put("fa:pause-circle-o", "\uf28c");
        map.put("fa:stop-circle", "\uf28d");
        map.put("fa:stop-circle-o", "\uf28e");
        map.put("fa:shopping-bag", "\uf290");
        map.put("fa:shopping-basket", "\uf291");
        map.put("fa:hashtag", "\uf292");
        map.put("fa:bluetooth", "\uf293");
        map.put("fa:bluetooth-b", "\uf294");
        map.put("fa:percent", "\uf295");
        map.put("fa:gitlab", "\uf296");
        map.put("fa:wpbeginner", "\uf297");
        map.put("fa:wpforms", "\uf298");
        map.put("fa:envira", "\uf299");
        map.put("fa:universal-access", "\uf29a");
        map.put("fa:wheelchair-alt", "\uf29b");
        map.put("fa:question-circle-o", "\uf29c");
        map.put("fa:blind", "\uf29d");
        map.put("fa:audio-description", "\uf29e");
        map.put("fa:volume-control-phone", "\uf2a0");
        map.put("fa:braille", "\uf2a1");
        map.put("fa:assistive-listening-systems", "\uf2a2");
        map.put("fa:asl-interpreting", "\uf2a3");
        map.put("fa:american-sign-language-interpreting", "\uf2a3");
        map.put("fa:deafness", "\uf2a4");
        map.put("fa:hard-of-hearing", "\uf2a4");
        map.put("fa:deaf", "\uf2a4");
        map.put("fa:glide", "\uf2a5");
        map.put("fa:glide-g", "\uf2a6");
        map.put("fa:signing", "\uf2a7");
        map.put("fa:sign-language", "\uf2a7");
        map.put("fa:low-vision", "\uf2a8");
        map.put("fa:viadeo", "\uf2a9");
        map.put("fa:viadeo-square", "\uf2aa");
        map.put("fa:snapchat", "\uf2ab");
        map.put("fa:snapchat-ghost", "\uf2ac");
        map.put("fa:snapchat-square", "\uf2ad");
        map.put("fa:pied-piper", "\uf2ae");
        map.put("fa:first-order", "\uf2b0");
        map.put("fa:yoast", "\uf2b1");
        map.put("fa:themeisle", "\uf2b2");
        map.put("fa:google-plus-circle", "\uf2b3");
        map.put("fa:google-plus-official", "\uf2b3");
        map.put("fa:fa", "\uf2b4");
        map.put("fa:font-awesome", "\uf2b4");
        map.put("fa:handshake-o", "\uf2b5");
        map.put("fa:envelope-open", "\uf2b6");
        map.put("fa:envelope-open-o", "\uf2b7");
        map.put("fa:linode", "\uf2b8");
        map.put("fa:address-book", "\uf2b9");
        map.put("fa:address-book-o", "\uf2ba");
        map.put("fa:vcard", "\uf2bb");
        map.put("fa:address-card", "\uf2bb");
        map.put("fa:vcard-o", "\uf2bc");
        map.put("fa:address-card-o", "\uf2bc");
        map.put("fa:user-circle", "\uf2bd");
        map.put("fa:user-circle-o", "\uf2be");
        map.put("fa:user-o", "\uf2c0");
        map.put("fa:id-badge", "\uf2c1");
        map.put("fa:drivers-license", "\uf2c2");
        map.put("fa:id-card", "\uf2c2");
        map.put("fa:drivers-license-o", "\uf2c3");
        map.put("fa:id-card-o", "\uf2c3");
        map.put("fa:quora", "\uf2c4");
        map.put("fa:free-code-camp", "\uf2c5");
        map.put("fa:telegram", "\uf2c6");
        map.put("fa:thermometer-4", "\uf2c7");
        map.put("fa:thermometer", "\uf2c7");
        map.put("fa:thermometer-full", "\uf2c7");
        map.put("fa:thermometer-3", "\uf2c8");
        map.put("fa:thermometer-three-quarters", "\uf2c8");
        map.put("fa:thermometer-2", "\uf2c9");
        map.put("fa:thermometer-half", "\uf2c9");
        map.put("fa:thermometer-1", "\uf2ca");
        map.put("fa:thermometer-quarter", "\uf2ca");
        map.put("fa:thermometer-0", "\uf2cb");
        map.put("fa:thermometer-empty", "\uf2cb");
        map.put("fa:shower", "\uf2cc");
        map.put("fa:bathtub", "\uf2cd");
        map.put("fa:s15", "\uf2cd");
        map.put("fa:bath", "\uf2cd");
        map.put("fa:podcast", "\uf2ce");
        map.put("fa:window-maximize", "\uf2d0");
        map.put("fa:window-minimize", "\uf2d1");
        map.put("fa:window-restore", "\uf2d2");
        map.put("fa:times-rectangle", "\uf2d3");
        map.put("fa:window-close", "\uf2d3");
        map.put("fa:times-rectangle-o", "\uf2d4");
        map.put("fa:window-close-o", "\uf2d4");
        map.put("fa:bandcamp", "\uf2d5");
        map.put("fa:grav", "\uf2d6");
        map.put("fa:etsy", "\uf2d7");
        map.put("fa:imdb", "\uf2d8");
        map.put("fa:ravelry", "\uf2d9");
        map.put("fa:eercast", "\uf2da");
        map.put("fa:microchip", "\uf2db");
        map.put("fa:snowflake-o", "\uf2dc");
        map.put("fa:superpowers", "\uf2dd");
        map.put("fa:wpexplorer", "\uf2de");
        map.put("fa:meetup", "\uf2e0");
        return map;
    }
    
}
