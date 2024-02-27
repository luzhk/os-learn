package date;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class DateUtils {

    public static void main(String[] args) {
        Date preMonth = org.apache.commons.lang3.time.DateUtils.addMonths(new Date(), -1);
        DateTime begin = DateUtil.beginOfMonth(preMonth);
        DateTime end = DateUtil.endOfMonth(preMonth);
        System.out.println(begin.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(end.toString("yyyy-MM-dd HH:mm:ss"));

    }
}
