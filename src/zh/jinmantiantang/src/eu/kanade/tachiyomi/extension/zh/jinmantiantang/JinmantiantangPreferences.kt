package eu.kanade.tachiyomi.extension.zh.jinmantiantang

import android.content.Context
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference

internal fun getPreferenceList(context: Context) = arrayOf(
    ListPreference(context).apply {
        key = MAINSITE_RATELIMIT_PREF
        title = "在限制时间内（下个设置项）允许的请求数量。"
        entries = (1..10).map { i -> i.toString() }.toTypedArray()
        entryValues = (1..10).map { i -> i.toString() }.toTypedArray()
        summary = "此值影响更新书架时发起连接请求的数量。调低此值可能减小IP被屏蔽的几率，但加载速度也会变慢。需要重启软件以生效。\n当前值：%s"

        setDefaultValue(MAINSITE_RATELIMIT_PREF_DEFAULT)
    },

    ListPreference(context).apply {
        key = MAINSITE_RATELIMIT_PERIOD
        title = "限制持续时间。单位秒"
        entries = (1..60).map { i -> i.toString() }.toTypedArray()
        entryValues = (1..60).map { i -> i.toString() }.toTypedArray()
        summary = "此值影响更新书架时请求的间隔时间。调大此值可能减小IP被屏蔽的几率，但更新时间也会变慢。需要重启软件以生效。\n当前值：%s"

        setDefaultValue(MAINSITE_RATELIMIT_PERIOD_DEFAULT)
    },

    ListPreference(context).apply {
        key = USE_MIRROR_URL_PREF
        title = "使用镜像网址"
        entries = SITE_ENTRIES_ARRAY_DESCRIPTION
        entryValues = SITE_ENTRIES_ARRAY.indices.map { it.toString() }.toTypedArray()
        summary = "使用镜像网址。需要重启软件以生效。"

        setDefaultValue("0")
    },

    EditTextPreference(context).apply {
        key = BLOCK_PREF
        title = "屏蔽词列表"
        setDefaultValue(
            "// 例如 \"YAOI cos 扶他 毛絨絨 獵奇 韩漫 韓漫\", " +
                "关键词之间用空格分离, 大小写不敏感, \"//\"后的字符会被忽略"
        )
        dialogTitle = "关键词列表"
    },
)

internal const val BLOCK_PREF = "BLOCK_GENRES_LIST"

internal const val MAINSITE_RATELIMIT_PREF = "mainSiteRateLimitPreference"
internal const val MAINSITE_RATELIMIT_PREF_DEFAULT = 1.toString()

internal const val MAINSITE_RATELIMIT_PERIOD = "mainSiteRateLimitPeriodPreference"
internal const val MAINSITE_RATELIMIT_PERIOD_DEFAULT = 3.toString()

internal const val USE_MIRROR_URL_PREF = "useMirrorWebsitePreference"

internal val SITE_ENTRIES_ARRAY_DESCRIPTION = arrayOf(
    "主站", "海外分流",
    "中国大陆总站", "中国大陆分流","中国大陆分流2",
    "东南亚线路1", "东南亚线路2",
)

// List is based on https://jmcomic.bet/
// Please also update AndroidManifest
internal val SITE_ENTRIES_ARRAY = arrayOf(
    "18comic.vip", "18comic.org",
    "jmcomic2.more", "jmcomic.win","jmcomic1.moe",
    "jmcomic.me", "jmcomic1.me",
)
