package com.lunzn.artist.cache;

/**
 * CacheKey定义类
 * <功能详细描述>
 * @author  suhongpeng
 * @version  [版本号, 2017年11月2日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class CacheKey
{
    /**
     * 定义缓存key
     * <功能详细描述>
     * @author  suhongpeng
     * @version  [版本号, 2017年11月2日]
     * @see  [相关类/方法]
     * @since  [产品/模块版本]
     */
    public enum KvMapping
    {
        
        /**
         * 艺人详细信息key
         */
        artist_detaileartist("client:clientid:%s");
        
        private String mapping;
        
        /**
         * <默认构造函数>
         */
        private KvMapping(String mapping)
        {
            this.mapping = mapping;
        }
        
        public String getMapping()
        {
            return mapping;
        }
        
        /**
         * 格式化key
         * <一句话功能简述>
         * <功能详细描述>
         * @param args 需要传入的参数用来格式化key
         * @return 格式化后的key
         * @see [类、类#方法、类#成员]
         */
        public String format(Object... args)
        {
            return String.format(mapping, args);
        }
    }
}
