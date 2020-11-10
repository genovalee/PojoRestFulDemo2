## POJO RESTFul Api 程式撰寫、測試及部署 
## 建立 MD 資料表

MASTER TABLE:
<pre style="color:#000000;background:#ffffff;">Create table t0nj0547 
<span style="color:#808030; ">(</span> 
  BUSSRFNO     VARCHAR2<span style="color:#808030; ">(</span><span style="color:#008c00; ">8</span><span style="color:#808030; ">)</span><span style="color:#808030; ">,</span>           <span style="color:#808030; ">-</span><span style="color:#808030; ">-</span>商業統一編號  
  BUSSNM       VARCHAR2<span style="color:#808030; ">(</span><span style="color:#008c00; ">255</span><span style="color:#808030; ">)</span><span style="color:#808030; ">,</span>         <span style="color:#808030; ">-</span><span style="color:#808030; ">-</span>商業名稱  
  COSTSID      VARCHAR2<span style="color:#808030; ">(</span><span style="color:#008c00; ">2</span><span style="color:#808030; ">)</span><span style="color:#808030; ">,</span>           <span style="color:#808030; ">-</span><span style="color:#808030; ">-</span>公司狀態代碼  
  COSTSIDCOMT  VARCHAR2<span style="color:#808030; ">(</span><span style="color:#008c00; ">255</span><span style="color:#808030; ">)</span><span style="color:#808030; ">,</span>         <span style="color:#808030; ">-</span><span style="color:#808030; ">-</span>公司狀態說明  
  REGOFC       VARCHAR2<span style="color:#808030; ">(</span><span style="color:#008c00; ">15</span><span style="color:#808030; ">)</span><span style="color:#808030; ">,</span>          <span style="color:#808030; ">-</span><span style="color:#808030; ">-</span>登記機關  
  REGOFCCOMT   VARCHAR2<span style="color:#808030; ">(</span><span style="color:#008c00; ">255</span><span style="color:#808030; ">)</span><span style="color:#808030; ">,</span>         <span style="color:#808030; ">-</span><span style="color:#808030; ">-</span>登記機關說明<span style="color:#808030; ">  
  BUSSLOCATION VARCHAR2<span style="color:#808030; ">(</span><span style="color:#008c00; ">512</span><span style="color:#808030; ">)</span><span style="color:#808030; ">,</span>         <span style="color:#808030; ">-</span><span style="color:#808030; ">-</span>商業所在地<span style="color:#808030; ">,</span> 
  TXDAT     DATE<span style="color:#808030; ">,</span> 
  constraint PK_T0NJ0547 primary key <span style="color:#808030; ">(</span>BUSSRFNO<span style="color:#808030; ">,</span> REGOFC<span style="color:#808030; ">)</span> 
<span style="color:#808030; ">)</span><span style="color:#800080; ">;</span> 
</pre>
DETAIL TABLE

<pre style="color:#000000;background:#ffffff;">Create table t0nj0547d 
<span style="color:#808030; ">(</span> 
  BUSSRFNO  VARCHAR2<span style="color:#808030; ">(</span><span style="color:#008c00; ">8</span><span style="color:#808030; ">)</span><span style="color:#808030; ">,</span>               <span style="color:#808030; ">-</span><span style="color:#808030; ">-</span>商業統一編號  
  REGOFC    VARCHAR2<span style="color:#808030; ">(</span><span style="color:#008c00; ">255</span><span style="color:#808030; ">)</span><span style="color:#808030; ">,</span>             <span style="color:#808030; ">-</span><span style="color:#808030; ">-</span>登記機關<span style="color:#808030; "></span>  
  IT        VARCHAR2<span style="color:#808030; ">(</span><span style="color:#008c00; ">4</span><span style="color:#808030; ">)</span><span style="color:#808030; ">,</span>               <span style="color:#808030; ">-</span><span style="color:#808030; ">-</span>營業項目序號  
  SALIT     VARCHAR2<span style="color:#808030; ">(</span><span style="color:#008c00; ">10</span><span style="color:#808030; ">)</span><span style="color:#808030; ">,</span>              <span style="color:#808030; ">-</span><span style="color:#808030; ">-</span>營業項目代號  
  SALITCOMT VARCHAR2<span style="color:#808030; ">(</span><span style="color:#008c00; ">2000</span><span style="color:#808030; ">)</span><span style="color:#808030; ">,</span>            <span style="color:#808030; ">-</span><span style="color:#808030; ">-</span>營業項目名稱 
  TXDAT     DATE<span style="color:#808030; ">,</span> 
  constraint PK_T0NJ0547D primary key <span style="color:#808030; ">(</span>BUSSRFNO<span style="color:#808030; ">,</span> REGOFC<span style="color:#808030; ">,</span> SALIT<span style="color:#808030; ">)</span><span style="color:#808030; ">,</span> 
  constraint FK_T0NJ0547D foreign key <span style="color:#808030; ">(</span>BUSSRFNO<span style="color:#808030; ">,</span> REGOFC<span style="color:#808030; ">)</span> 
  references T0NJ0547 <span style="color:#808030; ">(</span>BUSSRFNO<span style="color:#808030; ">,</span> REGOFC<span style="color:#808030; ">)</span> on delete cascade 
<span style="color:#808030; ">)</span><span style="color:#800080; ">;</span> 
</pre>

## 增設Java Class並宣告變數，並產生get/set method

<pre style="color:#000000;background:#ffffff;">@XmlRootElement(name = "t0nj0547d")
public class T0nj0547d implements Serializable{
    public T0nj0547d() {
        super()<span style="color:#800080; ">;</span>
    }
    private String bussrfno<span style="color:#800080; ">;</span>
    private String regofc<span style="color:#800080; ">;</span>
    private String it<span style="color:#800080; ">;</span>
    private String salit<span style="color:#800080; ">;</span>
    private String salitcomt<span style="color:#800080; ">;</span>
}	
</pre>


<pre style="color:#000000;background:#ffffff;">@XmlRootElement(name = "t0nj0547")
public class T0nj0547 implements Serializable{
    public T0nj0547() {
        super()<span style="color:#800080; ">;</span>
    }
    private String bussrfno<span style="color:#800080; ">;</span>
    private String bussnm<span style="color:#800080; ">;</span>
    private String costsid<span style="color:#800080; ">;</span>
    private String costsidcomt<span style="color:#800080; ">;</span>
    private String regofc<span style="color:#800080; ">;</span>
    private String regofccomt<span style="color:#800080; ">;</span>
    private String busslocation<span style="color:#800080; ">;</span>
    private List<span style="color:#a65700; ">&lt;</span><span style="color:#5f5035; ">T0nj0547d</span><span style="color:#a65700; ">&gt;</span> t0nj0547d<span style="color:#800080; ">;</span>
}
</pre>
## 增設Java Interface作為service get/post 實作之用
### post使用addT0nj0547方法，get使用gett0nj0547ByBussRfnoRegoFc方法

<pre style="color:#000000;background:#ffffff;">public interface T0nj0547Service <span style="color:#800080; ">{</span>
    public Response addT0nj0547<span style="color:#808030; ">(</span>T0nj0547 t47<span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>

    public T0nj0547 getT0nj0547ByBussRfnoRegoFc<span style="color:#808030; ">(</span><span style="color:#603000; ">String</span> bussrfno<span style="color:#808030; ">,</span> <span style="color:#603000; ">String</span> regofc<span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
<span style="color:#800080; ">}</span>
</pre>
## 增設Java Class實作上面宣告的Interface
### Override addT0nj0547()

<pre style="color:#000000;background:#ffffff;">public class T0nj0547ServiceImp implements T0nj0547Service <span style="color:#800080; ">{</span>
    private Connection conn<span style="color:#800080; ">;</span>

    public T0nj0547ServiceImp<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span> throws NamingException<span style="color:#808030; ">,</span> SQLException <span style="color:#800080; ">{</span>
        super<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        InitialContext ic <span style="color:#808030; ">=</span> new InitialContext<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        DataSource ds <span style="color:#808030; ">=</span> <span style="color:#808030; ">(</span>DataSource<span style="color:#808030; ">)</span> ic<span style="color:#808030; ">.</span>lookup<span style="color:#808030; ">(</span><span style="color:#800000; ">"</span><span style="color:#0000e6; ">java:comp/env/jdbc/XXXXDS</span><span style="color:#800000; ">"</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        conn <span style="color:#808030; ">=</span> ds<span style="color:#808030; ">.</span>getConnection<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        conn<span style="color:#808030; ">.</span>setAutoCommit<span style="color:#808030; ">(</span>true<span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
    <span style="color:#800080; ">}</span>

	<span style="color:#808030; ">@</span>Override
    public Response addT0nj0547<span style="color:#808030; ">(</span>T0nj0547 t47<span style="color:#808030; ">)</span> throws NamingException<span style="color:#808030; ">,</span> SQLException <span style="color:#800080; ">{</span>
        try <span style="color:#800080; ">{</span>
            InsertDbT0nj0547 insT0nj0547 <span style="color:#808030; ">=</span> new InsertDbT0nj0547<span style="color:#808030; ">(</span>conn<span style="color:#808030; ">,</span> t47<span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
            insT0nj0547<span style="color:#808030; ">.</span>InsertDbT0nj0547<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
            <span style="color:#800000; font-weight:bold; ">if</span> <span style="color:#808030; ">(</span>t47<span style="color:#808030; ">.</span>getT0nj0547d<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">.</span>size<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span> <span style="color:#808030; ">&gt;</span> <span style="color:#008c00; ">0</span><span style="color:#808030; ">)</span> <span style="color:#800080; ">{</span>
                InsertDbT0nj0547d insT0nj0547d <span style="color:#808030; ">=</span> new InsertDbT0nj0547d<span style="color:#808030; ">(</span>conn<span style="color:#808030; ">,</span> t47<span style="color:#808030; ">.</span>getT0nj0547d<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
                insT0nj0547d<span style="color:#808030; ">.</span>InsertDbT0nj0547d<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
            <span style="color:#800080; ">}</span>

            <span style="color:#603000; ">String</span> resp <span style="color:#808030; ">=</span> <span style="color:#800000; ">"</span><span style="color:#0000e6; ">{</span><span style="color:#0f69ff; ">\"</span><span style="color:#0000e6; ">message</span><span style="color:#0f69ff; ">\"</span><span style="color:#0000e6; ">:</span><span style="color:#0f69ff; ">\"</span><span style="color:#0000e6; ">資料已新增</span><span style="color:#0f69ff; ">\"</span><span style="color:#0000e6; ">,</span><span style="color:#0f69ff; ">\"</span><span style="color:#0000e6; ">status</span><span style="color:#0f69ff; ">\"</span><span style="color:#0000e6; ">:</span><span style="color:#0f69ff; ">\"</span><span style="color:#800000; ">"</span> <span style="color:#808030; ">+</span> Response<span style="color:#808030; ">.</span>Status<span style="color:#808030; ">.</span>CREATED <span style="color:#808030; ">+</span> <span style="color:#800000; ">"</span><span style="color:#0f69ff; ">\"</span><span style="color:#0000e6; ">}</span><span style="color:#800000; ">"</span><span style="color:#800080; ">;</span>
            <span style="color:#800000; font-weight:bold; ">return</span> Response<span style="color:#808030; ">.</span>status<span style="color:#808030; ">(</span>Response<span style="color:#808030; ">.</span>Status<span style="color:#808030; ">.</span>CREATED<span style="color:#808030; ">)</span>
                           <span style="color:#808030; ">.</span>entity<span style="color:#808030; ">(</span>resp<span style="color:#808030; ">)</span>
                           <span style="color:#808030; ">.</span>build<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        <span style="color:#800080; ">}</span> catch <span style="color:#808030; ">(</span>SQLException ex<span style="color:#808030; ">)</span> <span style="color:#800080; ">{</span>
            ex<span style="color:#808030; ">.</span>printStackTrace<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
            System<span style="color:#808030; ">.</span>out<span style="color:#808030; ">.</span>println<span style="color:#808030; ">(</span>ex<span style="color:#808030; ">.</span>getMessage<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
            <span style="color:#603000; ">String</span> resp <span style="color:#808030; ">=</span> <span style="color:#800000; ">"</span><span style="color:#0000e6; ">{</span><span style="color:#0f69ff; ">\"</span><span style="color:#0000e6; ">message</span><span style="color:#0f69ff; ">\"</span><span style="color:#0000e6; ">:</span><span style="color:#0f69ff; ">\"</span><span style="color:#800000; ">"</span> <span style="color:#808030; ">+</span> ex<span style="color:#808030; ">.</span>getMessage<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">.</span>replace<span style="color:#808030; ">(</span><span style="color:#800000; ">"</span><span style="color:#0f69ff; ">\"</span><span style="color:#800000; ">"</span><span style="color:#808030; ">,</span> <span style="color:#800000; ">"</span><span style="color:#0f69ff; ">\'</span><span style="color:#800000; ">"</span><span style="color:#808030; ">)</span> <span style="color:#808030; ">+</span> <span style="color:#800000; ">"</span><span style="color:#0f69ff; ">\"</span><span style="color:#0000e6; ">}</span><span style="color:#800000; ">"</span><span style="color:#800080; ">;</span>
            <span style="color:#800000; font-weight:bold; ">return</span> Response<span style="color:#808030; ">.</span>status<span style="color:#808030; ">(</span>Response<span style="color:#808030; ">.</span>Status<span style="color:#808030; ">.</span>CREATED<span style="color:#808030; ">)</span>
                           <span style="color:#808030; ">.</span>entity<span style="color:#808030; ">(</span>resp<span style="color:#808030; ">)</span>
                           <span style="color:#808030; ">.</span>build<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        <span style="color:#800080; ">}</span> catch <span style="color:#808030; ">(</span>Exception e<span style="color:#808030; ">)</span> <span style="color:#800080; ">{</span>
            <span style="color:#696969; ">// </span><span style="color:#ffffff; background:#808000; ">TODO: Add catch code</span>
            e<span style="color:#808030; ">.</span>printStackTrace<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        <span style="color:#800080; ">}</span> <span style="color:#800000; font-weight:bold; ">finally</span> <span style="color:#800080; ">{</span>
            <span style="color:#800000; font-weight:bold; ">if</span> <span style="color:#808030; ">(</span>conn <span style="color:#808030; ">!</span><span style="color:#808030; ">=</span> null<span style="color:#808030; ">)</span> <span style="color:#800080; ">{</span>
                try <span style="color:#800080; ">{</span>
                    conn<span style="color:#808030; ">.</span>close<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
                <span style="color:#800080; ">}</span> catch <span style="color:#808030; ">(</span>SQLException e<span style="color:#808030; ">)</span> <span style="color:#800080; ">{</span>
                    System<span style="color:#808030; ">.</span>out<span style="color:#808030; ">.</span>println<span style="color:#808030; ">(</span><span style="color:#800000; ">"</span><span style="color:#0000e6; ">資料庫連線異常</span><span style="color:#800000; ">"</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
                <span style="color:#800080; ">}</span>
            <span style="color:#800080; ">}</span>
        <span style="color:#800080; ">}</span>
        <span style="color:#800000; font-weight:bold; ">return</span> null<span style="color:#800080; ">;</span>
    <span style="color:#800080; ">}</span>
<span style="color:#800080; ">}</span>	
</pre>

### Override getT0nj0547ByBussRfnoRegoFc

<pre style="color:#000000;background:#ffffff;">public class T0nj0547ServiceImp implements T0nj0547Service <span style="color:#800080; ">{</span>
    private Connection conn<span style="color:#800080; ">;</span>

    public T0nj0547ServiceImp<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span> throws NamingException<span style="color:#808030; ">,</span> SQLException <span style="color:#800080; ">{</span>
        super<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        InitialContext ic <span style="color:#808030; ">=</span> new InitialContext<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        DataSource ds <span style="color:#808030; ">=</span> <span style="color:#808030; ">(</span>DataSource<span style="color:#808030; ">)</span> ic<span style="color:#808030; ">.</span>lookup<span style="color:#808030; ">(</span><span style="color:#800000; ">"</span><span style="color:#0000e6; ">java:comp/env/jdbc/XXXXDS</span><span style="color:#800000; ">"</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        conn <span style="color:#808030; ">=</span> ds<span style="color:#808030; ">.</span>getConnection<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        conn<span style="color:#808030; ">.</span>setAutoCommit<span style="color:#808030; ">(</span>true<span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
    <span style="color:#800080; ">}</span>

    <pre style='color:#000000;background:#ffffff;'>    <span style='color:#7f9fbf; font-weight:bold; '>@Override</span>
    <span style='color:#7f9fbf; font-weight:bold; '>@GET</span>
    <span style='color:#7f9fbf; font-weight:bold; '>@Produces("application/json")</span>
    <span style='color:#7f9fbf; font-weight:bold; '>@Path("/get")</span>
    <span style='color:#800000; font-weight:bold; '>public</span> T0nj0547 getT0nj0547ByBussRfnoRegoFc(<span style='color:#7f9fbf; font-weight:bold; '>@QueryParam("bussrfno")</span> <span style='color:#7f9fbf; font-weight:bold; '>@DefaultValue("98765433")</span> String bussrfno,
                                                <span style='color:#7f9fbf; font-weight:bold; '>@QueryParam("regofc")</span> <span style='color:#7f9fbf; font-weight:bold; '>@DefaultValue("376430000A")</span>
                                                String regofc) <span style='color:#800080; '>{</span>
        <span style='color:#bb7977; font-weight:bold; '>PreparedStatement</span> ps <span style='color:#808030; '>=</span> <span style='color:#800000; font-weight:bold; '>null</span><span style='color:#808030; '>,</span> ps2 <span style='color:#808030; '>=</span> <span style='color:#800000; font-weight:bold; '>null</span><span style='color:#800080; '>;</span>
        <span style='color:#bb7977; font-weight:bold; '>String</span> sql <span style='color:#808030; '>=</span>
            <span style='color:#0000e6; '>"select bussrfno, bussnm, costsid, costsidcomt, regofc, regofccomt, busslocation from t0nj0547 where bussrfno=? and regofc=?"</span><span style='color:#800080; '>;</span>
        <span style='color:#bb7977; font-weight:bold; '>String</span> sql2 <span style='color:#808030; '>=</span> <span style='color:#0000e6; '>"select bussrfno, regofc, it, salit, salitcomt from t0nj0547d where bussrfno=? and regofc=?"</span><span style='color:#800080; '>;</span>
        <span style='color:#bb7977; font-weight:bold; '>List</span><span style='color:#808030; '>&lt;</span>T0nj0547d<span style='color:#808030; '>></span> t0nj0547ds <span style='color:#808030; '>=</span> <span style='color:#800000; font-weight:bold; '>new</span> <span style='color:#bb7977; font-weight:bold; '>ArrayList</span><span style='color:#808030; '>&lt;</span>T0nj0547d<span style='color:#808030; '>></span><span style='color:#808030; '>(</span><span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>

        <span style='color:#800000; font-weight:bold; '>try</span> <span style='color:#800080; '>{</span>
            ps <span style='color:#808030; '>=</span> conn<span style='color:#808030; '>.</span>prepareStatement<span style='color:#808030; '>(</span>sql<span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
            ps<span style='color:#808030; '>.</span>setString<span style='color:#808030; '>(</span><span style='color:#008c00; '>1</span><span style='color:#808030; '>,</span> bussrfno<span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
            ps<span style='color:#808030; '>.</span>setString<span style='color:#808030; '>(</span><span style='color:#008c00; '>2</span><span style='color:#808030; '>,</span> regofc<span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
            <span style='color:#bb7977; font-weight:bold; '>ResultSet</span> rs <span style='color:#808030; '>=</span> ps<span style='color:#808030; '>.</span>executeQuery<span style='color:#808030; '>(</span><span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
            <span style='color:#800000; font-weight:bold; '>if</span> <span style='color:#808030; '>(</span>rs<span style='color:#808030; '>.</span>next<span style='color:#808030; '>(</span><span style='color:#808030; '>)</span><span style='color:#808030; '>)</span> <span style='color:#800080; '>{</span>
                ps2 <span style='color:#808030; '>=</span> conn<span style='color:#808030; '>.</span>prepareStatement<span style='color:#808030; '>(</span>sql2<span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
                ps2<span style='color:#808030; '>.</span>setString<span style='color:#808030; '>(</span><span style='color:#008c00; '>1</span><span style='color:#808030; '>,</span> rs<span style='color:#808030; '>.</span>getString<span style='color:#808030; '>(</span><span style='color:#0000e6; '>"bussrfno"</span><span style='color:#808030; '>)</span><span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
                ps2<span style='color:#808030; '>.</span>setString<span style='color:#808030; '>(</span><span style='color:#008c00; '>2</span><span style='color:#808030; '>,</span> rs<span style='color:#808030; '>.</span>getString<span style='color:#808030; '>(</span><span style='color:#0000e6; '>"regofc"</span><span style='color:#808030; '>)</span><span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
                <span style='color:#bb7977; font-weight:bold; '>ResultSet</span> rs2 <span style='color:#808030; '>=</span> ps2<span style='color:#808030; '>.</span>executeQuery<span style='color:#808030; '>(</span><span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
                <span style='color:#800000; font-weight:bold; '>while</span> <span style='color:#808030; '>(</span>rs2<span style='color:#808030; '>.</span>next<span style='color:#808030; '>(</span><span style='color:#808030; '>)</span><span style='color:#808030; '>)</span> <span style='color:#800080; '>{</span>
                    T0nj0547d t0nj0547d <span style='color:#808030; '>=</span> extractT0nj0547dFromResultSet<span style='color:#808030; '>(</span>rs2<span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
                    t0nj0547ds<span style='color:#808030; '>.</span>add<span style='color:#808030; '>(</span>t0nj0547d<span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
                <span style='color:#800080; '>}</span>
            <span style='color:#800080; '>}</span>
            <span style='color:#800000; font-weight:bold; '>return</span> extractT0nj0547FromResultSet<span style='color:#808030; '>(</span>rs<span style='color:#808030; '>,</span> t0nj0547ds<span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
        <span style='color:#800080; '>}</span> <span style='color:#800000; font-weight:bold; '>catch</span> <span style='color:#808030; '>(</span><span style='color:#bb7977; font-weight:bold; '>SQLException</span> ex<span style='color:#808030; '>)</span> <span style='color:#800080; '>{</span>
            ex<span style='color:#808030; '>.</span>printStackTrace<span style='color:#808030; '>(</span><span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
            ErrorMessage errorMessage <span style='color:#808030; '>=</span> <span style='color:#800000; font-weight:bold; '>new</span> ErrorMessage<span style='color:#808030; '>(</span><span style='color:#0000e6; '>"1001"</span><span style='color:#808030; '>,</span> <span style='color:#0000e6; '>"t0nj0547 not found!"</span><span style='color:#808030; '>,</span> <span style='color:#bb7977; font-weight:bold; '>Response</span><span style='color:#808030; '>.</span>Status<span style='color:#808030; '>.</span>NOT_FOUND<span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
            <span style='color:#800000; font-weight:bold; '>throw</span> <span style='color:#800000; font-weight:bold; '>new</span> NotFoundException<span style='color:#808030; '>(</span>errorMessage<span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
        <span style='color:#800080; '>}</span> <span style='color:#800000; font-weight:bold; '>catch</span> <span style='color:#808030; '>(</span><span style='color:#bb7977; font-weight:bold; '>Exception</span> e<span style='color:#808030; '>)</span> <span style='color:#800080; '>{</span>
            <span style='color:#696969; '>// </span><span style='color:#ffffff; background:#808000; '>TODO: Add catch code</span>
            e<span style='color:#808030; '>.</span>printStackTrace<span style='color:#808030; '>(</span><span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
        <span style='color:#800080; '>}</span> <span style='color:#800000; font-weight:bold; '>finally</span> <span style='color:#800080; '>{</span>
            <span style='color:#800000; font-weight:bold; '>if</span> <span style='color:#808030; '>(</span>conn <span style='color:#808030; '>!</span><span style='color:#808030; '>=</span> <span style='color:#800000; font-weight:bold; '>null</span><span style='color:#808030; '>)</span> <span style='color:#800080; '>{</span>
                <span style='color:#800000; font-weight:bold; '>try</span> <span style='color:#800080; '>{</span>
                    conn<span style='color:#808030; '>.</span>close<span style='color:#808030; '>(</span><span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
                <span style='color:#800080; '>}</span> <span style='color:#800000; font-weight:bold; '>catch</span> <span style='color:#808030; '>(</span><span style='color:#bb7977; font-weight:bold; '>SQLException</span> e<span style='color:#808030; '>)</span> <span style='color:#800080; '>{</span>
                    <span style='color:#bb7977; font-weight:bold; '>System</span><span style='color:#808030; '>.</span>out<span style='color:#808030; '>.</span>println<span style='color:#808030; '>(</span><span style='color:#0000e6; '>"資料庫連線異常"</span><span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
                <span style='color:#800080; '>}</span>
            <span style='color:#800080; '>}</span>
        <span style='color:#800080; '>}</span>
        <span style='color:#800000; font-weight:bold; '>return</span> <span style='color:#800000; font-weight:bold; '>null</span><span style='color:#800080; '>;</span>
    <span style='color:#800080; '>}</span>
</pre>
</pre>

## 增設兩個處理ResultSet的方法


<pre style="color:#000000;background:#ffffff;">    private T0nj0547 extractT0nj0547FromResultSet<span style="color:#808030; ">(</span>ResultSet rs<span style="color:#808030; ">,</span> List<span style="color:#808030; ">&lt;</span>T0nj0547d<span style="color:#808030; ">&gt;</span> t0nj0547ds<span style="color:#808030; ">)</span> throws SQLException <span style="color:#800080; ">{</span>
        T0nj0547 t0nj0547 <span style="color:#808030; ">=</span> new T0nj0547<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        t0nj0547<span style="color:#808030; ">.</span>setBussrfno<span style="color:#808030; ">(</span>rs<span style="color:#808030; ">.</span>getString<span style="color:#808030; ">(</span><span style="color:#800000; ">"</span><span style="color:#0000e6; ">bussrfno</span><span style="color:#800000; ">"</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        t0nj0547<span style="color:#808030; ">.</span>setBussnm<span style="color:#808030; ">(</span>rs<span style="color:#808030; ">.</span>getString<span style="color:#808030; ">(</span><span style="color:#800000; ">"</span><span style="color:#0000e6; ">bussnm</span><span style="color:#800000; ">"</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        t0nj0547<span style="color:#808030; ">.</span>setCostsid<span style="color:#808030; ">(</span>rs<span style="color:#808030; ">.</span>getString<span style="color:#808030; ">(</span><span style="color:#800000; ">"</span><span style="color:#0000e6; ">costsid</span><span style="color:#800000; ">"</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        t0nj0547<span style="color:#808030; ">.</span>setCostsidcomt<span style="color:#808030; ">(</span>rs<span style="color:#808030; ">.</span>getString<span style="color:#808030; ">(</span><span style="color:#800000; ">"</span><span style="color:#0000e6; ">costsidcomt</span><span style="color:#800000; ">"</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        t0nj0547<span style="color:#808030; ">.</span>setRegofc<span style="color:#808030; ">(</span>rs<span style="color:#808030; ">.</span>getString<span style="color:#808030; ">(</span><span style="color:#800000; ">"</span><span style="color:#0000e6; ">regofc</span><span style="color:#800000; ">"</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        t0nj0547<span style="color:#808030; ">.</span>setRegofccomt<span style="color:#808030; ">(</span>rs<span style="color:#808030; ">.</span>getString<span style="color:#808030; ">(</span><span style="color:#800000; ">"</span><span style="color:#0000e6; ">regofccomt</span><span style="color:#800000; ">"</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        t0nj0547<span style="color:#808030; ">.</span>setBusslocation<span style="color:#808030; ">(</span>rs<span style="color:#808030; ">.</span>getString<span style="color:#808030; ">(</span><span style="color:#800000; ">"</span><span style="color:#0000e6; ">busslocation</span><span style="color:#800000; ">"</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        t0nj0547<span style="color:#808030; ">.</span>setT0nj0547d<span style="color:#808030; ">(</span>t0nj0547ds<span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        <span style="color:#800000; font-weight:bold; ">return</span> t0nj0547<span style="color:#800080; ">;</span>
    <span style="color:#800080; ">}</span>
</pre>

<pre style="color:#000000;background:#ffffff;">    private T0nj0547d extractT0nj0547dFromResultSet<span style="color:#808030; ">(</span>ResultSet rs<span style="color:#808030; ">)</span> throws SQLException <span style="color:#800080; ">{</span>
        T0nj0547d t0nj0547d <span style="color:#808030; ">=</span> new T0nj0547d<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        t0nj0547d<span style="color:#808030; ">.</span>setBussrfno<span style="color:#808030; ">(</span>rs<span style="color:#808030; ">.</span>getString<span style="color:#808030; ">(</span><span style="color:#800000; ">"</span><span style="color:#0000e6; ">bussrfno</span><span style="color:#800000; ">"</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        t0nj0547d<span style="color:#808030; ">.</span>setRegofc<span style="color:#808030; ">(</span>rs<span style="color:#808030; ">.</span>getString<span style="color:#808030; ">(</span><span style="color:#800000; ">"</span><span style="color:#0000e6; ">regofc</span><span style="color:#800000; ">"</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        t0nj0547d<span style="color:#808030; ">.</span>setIt<span style="color:#808030; ">(</span>rs<span style="color:#808030; ">.</span>getString<span style="color:#808030; ">(</span><span style="color:#800000; ">"</span><span style="color:#0000e6; ">it</span><span style="color:#800000; ">"</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        t0nj0547d<span style="color:#808030; ">.</span>setSalit<span style="color:#808030; ">(</span>rs<span style="color:#808030; ">.</span>getString<span style="color:#808030; ">(</span><span style="color:#800000; ">"</span><span style="color:#0000e6; ">salit</span><span style="color:#800000; ">"</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        t0nj0547d<span style="color:#808030; ">.</span>setSalitcomt<span style="color:#808030; ">(</span>rs<span style="color:#808030; ">.</span>getString<span style="color:#808030; ">(</span><span style="color:#800000; ">"</span><span style="color:#0000e6; ">salitcomt</span><span style="color:#800000; ">"</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        <span style="color:#800000; font-weight:bold; ">return</span> t0nj0547d<span style="color:#800080; ">;</span>
    <span style="color:#800080; ">}</span>
</pre>

## 增設兩個Insert Table的類別

<pre style="color:#000000;background:#ffffff;">public class InsertDbT0nj0547 <span style="color:#800080; ">{</span>
    private Connection conn <span style="color:#808030; ">=</span> null<span style="color:#800080; ">;</span>
    private T0nj0547 t47<span style="color:#800080; ">;</span>

    public InsertDbT0nj0547<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span> <span style="color:#800080; ">{</span>
    <span style="color:#800080; ">}</span>
    <span style="color:#696969; ">//CONSTRUCTOR</span>
    public InsertDbT0nj0547<span style="color:#808030; ">(</span>Connection conn<span style="color:#808030; ">,</span> T0nj0547 t47<span style="color:#808030; ">)</span> <span style="color:#800080; ">{</span>
        <span style="color:#800000; font-weight:bold; ">this</span><span style="color:#808030; ">.</span>conn <span style="color:#808030; ">=</span> conn<span style="color:#800080; ">;</span>
        <span style="color:#800000; font-weight:bold; ">this</span><span style="color:#808030; ">.</span>t47 <span style="color:#808030; ">=</span> t47<span style="color:#800080; ">;</span>
    <span style="color:#800080; ">}</span>

    public <span style="color:#800000; font-weight:bold; ">void</span> InsertDbT0nj0547<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span> throws SQLException <span style="color:#800080; ">{</span>
        Date date <span style="color:#808030; ">=</span> new Date<span style="color:#808030; ">(</span>System<span style="color:#808030; ">.</span>currentTimeMillis<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        Timestamp today <span style="color:#808030; ">=</span> new Timestamp<span style="color:#808030; ">(</span>date<span style="color:#808030; ">.</span>getTime<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        <span style="color:#603000; ">String</span> sql <span style="color:#808030; ">=</span>
            <span style="color:#800000; ">"</span><span style="color:#0000e6; ">INSERT INTO t0nj0547(bussrfno, bussnm, costsid, costsidcomt, regofc, regofccomt, busslocation, txdat) </span><span style="color:#800000; ">"</span> <span style="color:#808030; ">+</span>
            <span style="color:#800000; ">"</span><span style="color:#0000e6; ">VALUES (?,?,?,?,?,?,?,?)</span><span style="color:#800000; ">"</span><span style="color:#800080; ">;</span>
        PreparedStatement ps <span style="color:#808030; ">=</span> conn<span style="color:#808030; ">.</span>prepareStatement<span style="color:#808030; ">(</span>sql<span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        ps<span style="color:#808030; ">.</span>setString<span style="color:#808030; ">(</span><span style="color:#008c00; ">1</span><span style="color:#808030; ">,</span> t47<span style="color:#808030; ">.</span>getBussrfno<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        ps<span style="color:#808030; ">.</span>setString<span style="color:#808030; ">(</span><span style="color:#008c00; ">2</span><span style="color:#808030; ">,</span> t47<span style="color:#808030; ">.</span>getBussnm<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        ps<span style="color:#808030; ">.</span>setString<span style="color:#808030; ">(</span><span style="color:#008c00; ">3</span><span style="color:#808030; ">,</span> t47<span style="color:#808030; ">.</span>getCostsid<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        ps<span style="color:#808030; ">.</span>setString<span style="color:#808030; ">(</span><span style="color:#008c00; ">4</span><span style="color:#808030; ">,</span> t47<span style="color:#808030; ">.</span>getCostsidcomt<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        ps<span style="color:#808030; ">.</span>setString<span style="color:#808030; ">(</span><span style="color:#008c00; ">5</span><span style="color:#808030; ">,</span> t47<span style="color:#808030; ">.</span>getRegofc<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        ps<span style="color:#808030; ">.</span>setString<span style="color:#808030; ">(</span><span style="color:#008c00; ">6</span><span style="color:#808030; ">,</span> t47<span style="color:#808030; ">.</span>getRegofccomt<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        ps<span style="color:#808030; ">.</span>setString<span style="color:#808030; ">(</span><span style="color:#008c00; ">7</span><span style="color:#808030; ">,</span> t47<span style="color:#808030; ">.</span>getBusslocation<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        ps<span style="color:#808030; ">.</span>setTimestamp<span style="color:#808030; ">(</span><span style="color:#008c00; ">8</span><span style="color:#808030; ">,</span> today<span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        ps<span style="color:#808030; ">.</span>execute<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        ps<span style="color:#808030; ">.</span>close<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
    <span style="color:#800080; ">}</span>
<span style="color:#800080; ">}</span>
</pre>

<pre style="color:#000000;background:#ffffff;">public class InsertDbT0nj0547d <span style="color:#800080; ">{</span>
    private Connection conn <span style="color:#808030; ">=</span> null<span style="color:#800080; ">;</span>
    private List<span style="color:#808030; ">&lt;</span>T0nj0547d<span style="color:#808030; ">&gt;</span> t47d <span style="color:#808030; ">=</span> new ArrayList<span style="color:#808030; ">&lt;</span>T0nj0547d<span style="color:#808030; ">&gt;</span><span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>

    public InsertDbT0nj0547d<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span> <span style="color:#800080; ">{</span>
    <span style="color:#800080; ">}</span>

    public InsertDbT0nj0547d<span style="color:#808030; ">(</span>Connection conn<span style="color:#808030; ">,</span> List<span style="color:#808030; ">&lt;</span>T0nj0547d<span style="color:#808030; ">&gt;</span> t47d<span style="color:#808030; ">)</span> <span style="color:#800080; ">{</span>
        <span style="color:#800000; font-weight:bold; ">this</span><span style="color:#808030; ">.</span>conn <span style="color:#808030; ">=</span> conn<span style="color:#800080; ">;</span>
        <span style="color:#800000; font-weight:bold; ">this</span><span style="color:#808030; ">.</span>t47d <span style="color:#808030; ">=</span> t47d<span style="color:#800080; ">;</span>
    <span style="color:#800080; ">}</span>

    public <span style="color:#800000; font-weight:bold; ">void</span> InsertDbT0nj0547d<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span> throws SQLException <span style="color:#800080; ">{</span>
        Date date <span style="color:#808030; ">=</span> new Date<span style="color:#808030; ">(</span>System<span style="color:#808030; ">.</span>currentTimeMillis<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        Timestamp today <span style="color:#808030; ">=</span> new Timestamp<span style="color:#808030; ">(</span>date<span style="color:#808030; ">.</span>getTime<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        <span style="color:#603000; ">String</span> sql <span style="color:#808030; ">=</span> <span style="color:#800000; ">"</span><span style="color:#0000e6; ">INSERT INTO t0nj0547d(bussrfno, regofc, it, salit, salitcomt, txdat) VALUES (?,?,?,?,?,?)</span><span style="color:#800000; ">"</span><span style="color:#800080; ">;</span>
        PreparedStatement ps <span style="color:#808030; ">=</span> conn<span style="color:#808030; ">.</span>prepareStatement<span style="color:#808030; ">(</span>sql<span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        <span style="color:#800000; font-weight:bold; ">for</span> <span style="color:#808030; ">(</span>T0nj0547d dt <span style="color:#800080; ">:</span> t47d<span style="color:#808030; ">)</span> <span style="color:#800080; ">{</span>
            ps<span style="color:#808030; ">.</span>setString<span style="color:#808030; ">(</span><span style="color:#008c00; ">1</span><span style="color:#808030; ">,</span> dt<span style="color:#808030; ">.</span>getBussrfno<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
            ps<span style="color:#808030; ">.</span>setString<span style="color:#808030; ">(</span><span style="color:#008c00; ">2</span><span style="color:#808030; ">,</span> dt<span style="color:#808030; ">.</span>getRegofc<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
            ps<span style="color:#808030; ">.</span>setString<span style="color:#808030; ">(</span><span style="color:#008c00; ">3</span><span style="color:#808030; ">,</span> dt<span style="color:#808030; ">.</span>getIt<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
            ps<span style="color:#808030; ">.</span>setString<span style="color:#808030; ">(</span><span style="color:#008c00; ">4</span><span style="color:#808030; ">,</span> dt<span style="color:#808030; ">.</span>getSalit<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
            ps<span style="color:#808030; ">.</span>setString<span style="color:#808030; ">(</span><span style="color:#008c00; ">5</span><span style="color:#808030; ">,</span> dt<span style="color:#808030; ">.</span>getSalitcomt<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
            ps<span style="color:#808030; ">.</span>setTimestamp<span style="color:#808030; ">(</span><span style="color:#008c00; ">6</span><span style="color:#808030; ">,</span> today<span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
            ps<span style="color:#808030; ">.</span>execute<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
        <span style="color:#800080; ">}</span>
        ps<span style="color:#808030; ">.</span>close<span style="color:#808030; ">(</span><span style="color:#808030; ">)</span><span style="color:#800080; ">;</span>
    <span style="color:#800080; ">}</span>
<span style="color:#800080; ">}</span>
</pre>
## 設定get/post的路徑，參數及Content-Type
![1](https://github.com/genovalee/POJORestfulDemo/blob/master/Image%20221.png)
 
<pre style='color:#000000;background:#ffffff;'><span style='color:#800000; font-weight:bold; '>package</span><span style='color:#004a43; '> client</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>exception</span><span style='color:#800080; '>;</span>

<span style='color:#800000; font-weight:bold; '>import</span><span style='color:#004a43; '> javax</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>ws</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>rs</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>core</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>Response</span><span style='color:#800080; '>;</span>

<span style='color:#800000; font-weight:bold; '>import</span><span style='color:#004a43; '> javax</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>xml</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>bind</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>annotation</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>XmlElement</span><span style='color:#800080; '>;</span>
<span style='color:#800000; font-weight:bold; '>import</span><span style='color:#004a43; '> javax</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>xml</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>bind</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>annotation</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>XmlRootElement</span><span style='color:#800080; '>;</span>

<span style='color:#7f9fbf; font-weight:bold; '>@XmlRootElement(name = "message")</span>
<span style='color:#800000; font-weight:bold; '>public</span> <span style='color:#800000; font-weight:bold; '>class</span> ErrorMessage <span style='color:#800080; '>{</span>
    <span style='color:#7f9fbf; font-weight:bold; '>@XmlElement</span>
    <span style='color:#800000; font-weight:bold; '>public</span> <span style='color:#bb7977; font-weight:bold; '>String</span> code<span style='color:#800080; '>;</span>
    <span style='color:#7f9fbf; font-weight:bold; '>@XmlElement</span>
    <span style='color:#800000; font-weight:bold; '>public</span> <span style='color:#bb7977; font-weight:bold; '>String</span> description<span style='color:#800080; '>;</span>
    <span style='color:#7f9fbf; font-weight:bold; '>@XmlElement</span>
    <span style='color:#800000; font-weight:bold; '>public</span> <span style='color:#bb7977; font-weight:bold; '>Response</span><span style='color:#808030; '>.</span>Status status<span style='color:#800080; '>;</span>

    <span style='color:#800000; font-weight:bold; '>public</span> ErrorMessage<span style='color:#808030; '>(</span><span style='color:#808030; '>)</span> <span style='color:#800080; '>{</span>
        <span style='color:#800000; font-weight:bold; '>super</span><span style='color:#808030; '>(</span><span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
    <span style='color:#800080; '>}</span>

    <span style='color:#800000; font-weight:bold; '>public</span> ErrorMessage<span style='color:#808030; '>(</span><span style='color:#bb7977; font-weight:bold; '>String</span> code<span style='color:#808030; '>,</span> <span style='color:#bb7977; font-weight:bold; '>String</span> description<span style='color:#808030; '>,</span> <span style='color:#bb7977; font-weight:bold; '>Response</span><span style='color:#808030; '>.</span>Status status<span style='color:#808030; '>)</span> <span style='color:#800080; '>{</span>
        <span style='color:#800000; font-weight:bold; '>this</span><span style='color:#808030; '>.</span>code <span style='color:#808030; '>=</span> code<span style='color:#800080; '>;</span>
        <span style='color:#800000; font-weight:bold; '>this</span><span style='color:#808030; '>.</span>description <span style='color:#808030; '>=</span> description<span style='color:#800080; '>;</span>
        <span style='color:#800000; font-weight:bold; '>this</span><span style='color:#808030; '>.</span>status <span style='color:#808030; '>=</span> status<span style='color:#800080; '>;</span>
    <span style='color:#800080; '>}</span>
<span style='color:#800080; '>}</span>
</pre>
<pre style='color:#000000;background:#ffffff;'>ppackage client.exception<span style='color:#808030; '>;</span>

<span style='color:#800000; font-weight:bold; '>import</span><span style='color:#004a43; '> javax</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>ws</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>rs</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>WebApplicationException</span><span style='color:#800080; '>;</span>
<span style='color:#800000; font-weight:bold; '>import</span><span style='color:#004a43; '> javax</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>ws</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>rs</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>core</span><span style='color:#808030; '>.</span><span style='color:#004a43; '>Response</span><span style='color:#800080; '>;</span>

<span style='color:#800000; font-weight:bold; '>public</span> <span style='color:#800000; font-weight:bold; '>class</span> NotFoundException <span style='color:#800000; font-weight:bold; '>extends</span> WebApplicationException <span style='color:#800080; '>{</span>
    <span style='color:#800000; font-weight:bold; '>public</span> NotFoundException<span style='color:#808030; '>(</span><span style='color:#808030; '>)</span> <span style='color:#800080; '>{</span>
        <span style='color:#800000; font-weight:bold; '>super</span><span style='color:#808030; '>(</span><span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
    <span style='color:#800080; '>}</span>

    <span style='color:#3f5fbf; '>/**</span>
<span style='color:#3f5fbf; '>&#xa0;&#xa0;&#xa0;&#xa0;&#xa0;</span><span style='color:#7f9fbf; font-weight:bold; '>*</span><span style='color:#3f5fbf; '></span>
<span style='color:#3f5fbf; '>&#xa0;&#xa0;&#xa0;&#xa0;&#xa0;*/</span>
    <span style='color:#800000; font-weight:bold; '>private</span> <span style='color:#800000; font-weight:bold; '>static</span> <span style='color:#800000; font-weight:bold; '>final</span> <span style='color:#bb7977; '>long</span> serialVersionUID <span style='color:#808030; '>=</span> <span style='color:#008c00; '>1</span><span style='color:#006600; '>L</span><span style='color:#800080; '>;</span>

    <span style='color:#3f5fbf; '>/**</span>
<span style='color:#3f5fbf; '>&#xa0;&#xa0;&#xa0;&#xa0;&#xa0;</span><span style='color:#7f9fbf; font-weight:bold; '>*</span><span style='color:#3f5fbf; '> Create a HTTP </span><span style='color:#008c00; '>404</span><span style='color:#3f5fbf; '> (Not Found) exception.</span>
<span style='color:#3f5fbf; '>&#xa0;&#xa0;&#xa0;&#xa0;&#xa0;</span><span style='color:#7f9fbf; font-weight:bold; '>*</span><span style='color:#3f5fbf; '> </span><span style='color:#7f9fbf; font-weight:bold; '>@param</span><span style='color:#3f5fbf; '> message the String that is the entity of the </span><span style='color:#008c00; '>404</span><span style='color:#3f5fbf; '> response.</span>
<span style='color:#3f5fbf; '>&#xa0;&#xa0;&#xa0;&#xa0;&#xa0;*/</span>
    <span style='color:#800000; font-weight:bold; '>public</span> NotFoundException<span style='color:#808030; '>(</span>ErrorMessage message<span style='color:#808030; '>)</span> <span style='color:#800080; '>{</span>
        <span style='color:#800000; font-weight:bold; '>super</span><span style='color:#808030; '>(</span><span style='color:#bb7977; font-weight:bold; '>Response</span><span style='color:#808030; '>.</span>status<span style='color:#808030; '>(</span><span style='color:#bb7977; font-weight:bold; '>Response</span><span style='color:#808030; '>.</span>Status<span style='color:#808030; '>.</span>NOT_FOUND<span style='color:#808030; '>)</span><span style='color:#808030; '>.</span>entity<span style='color:#808030; '>(</span>message<span style='color:#808030; '>)</span><span style='color:#808030; '>.</span>type<span style='color:#808030; '>(</span><span style='color:#0000e6; '>"application/json"</span><span style='color:#808030; '>)</span><span style='color:#808030; '>.</span>build<span style='color:#808030; '>(</span><span style='color:#808030; '>)</span><span style='color:#808030; '>)</span><span style='color:#800080; '>;</span>
    <span style='color:#800080; '>}</span>
<span style='color:#800080; '>}</span>
</pre>
