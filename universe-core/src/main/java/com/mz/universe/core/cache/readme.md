#关于缓存注解使用方法

###此注解只能用于标注与service方法上
列：
    
        @RdsServiceCache
          public List<Object> queryByPage(@CacheKey String key) {
        }
        
@RdsServiceCache 注解包含参数  expire 缓存过期时间 (毫秒) <br/>
 
@CacheKey 无参数 用于标注字符串类型的入参 或者 实体类型的入参 <br/> 注：当标注实体类型的入参 要表明实体内为key的 字段 并且有且只有一个字段<br/>
当前类型为非字符串或者为null值将忽略此key<br/> 当无此注解 缓存key默认会只使用当前类全路径名 加上方法名称<br/>  

新加 @FusionCacheKey 注解 此注解用于 被CacheKey注解标注的字段上 用于组合 缓存key 查询 
此注解 必须添加 index 用于标示缓存key 组合查询的顺序
列

    /**
     * 车牌号
     */
    @FusionCacheKey(index = 0)
    private String vehicleNo;
      
 
