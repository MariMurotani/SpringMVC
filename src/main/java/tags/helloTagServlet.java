package tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

//(2)タグハンドラクラスを作成するために、
//   Tagインタフェースを実装します。
public class helloTagServlet implements Tag {
  private PageContext pageContext;
  private Tag parentTag;

  public void setPageContext(PageContext pageContext) {
    this.pageContext = pageContext;
  }

  public void setParent(Tag parentTag) {
    this.parentTag = parentTag;
  }

  public Tag getParent() {
    return this.parentTag;
  }

  //(3)開始タグが呼び出されたときにを実行される
  //   doStartTagメソッドです。このメソッドに
  //   実行させたい処理を記述します。
  public int doStartTag() throws JspException {
    try {
      JspWriter out = pageContext.getOut();
      //(4)タグが実行されたときに画面に
      //   "Hello World!"と表示します。
      out.print("Hello World!");
    } catch(Exception e) {
      throw new JspException(e.getMessage());
    }
      return SKIP_BODY;
    }

    //(5)終了タグが呼び出されたときに実行される
    //   doEndTagメソッドです。このメソッドに
    //   実行させたい後処理を記述します。
    public int doEndTag() throws JspException {
      return EVAL_PAGE;
    }

  public void release() {}
}