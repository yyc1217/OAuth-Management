<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- info row --%>
<div class="row invoice-info">
    <div class="col-sm-12 invoice-col">

        <div id="preview">

            <div class="box box-info">
                <div class="box-header with-border">
                    <h3 class="box-title">關於開發者使用</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                                            本系統是NCU OAuth的管理介面，讓開發者可以管理<strong>NCU API</strong>的使用。
                </div><!-- /.box-body -->
            </div><!-- /.box -->

            <div class="box box-info">
                <div class="box-header with-border">
                    <h3 class="box-title">參考文件</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                   <p>我們所有的服務皆是開源的，包括<a href="https://github.com/NCU-CC/API-Documentation" target="_blank">NCU API</a>
                                                ，並提供多個app作為使用NCU API的範例及其衍生服務。</p>
                    <p>歡迎探索我們的<a href="https://github.com/NCU-CC">程式碼儲存庫</a>及<a href="https://play.google.com/store/apps/developer?id=%E5%9C%8B%E7%AB%8B%E4%B8%AD%E5%A4%AE%E5%A4%A7%E5%AD%B8%E9%9B%BB%E5%AD%90%E8%A8%88%E7%AE%97%E6%A9%9F%E4%B8%AD%E5%BF%83" target="_blank">Google Play</a>。</p>
                </div><!-- /.box-body -->
            </div><!-- /.box -->
            
            <div class="box box-danger">
                <div class="box-header with-border">
                    <h3 class="box-title">使用限制</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                    <p>每個NCU API皆有每月使用量限制，超過使用量則列入黑名單，若需要解除或有特殊需求者請<a href="mailto:mobile@cc.ncu.edu.tw">來信</a>告知。</p>
                    <dl class="dl-horizontal">
                        <dt>一般API</dt>
                        <dd>每月使用量：25000次 Requests</dd>
                        <dt>Personnel-Service</dt>
                        <dd>每月使用量：25000次 Requests；<p class="text-red">一分鐘試誤次數不得超過5次</p></dd>
                    </dl>
                </div><!-- /.box-body -->
            </div><!-- /.box -->
            
            <div class="box box-danger">
                <div class="box-header with-border">
                    <h3 class="box-title">黑名單</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
					<p>若應用服務被加入黑名單，則該服務的client_id、client_secret和api token會失效，將無法使用所有服務。</p>
					<p>若開發者帳號被加入黑名單，則該帳號將無法登入本系統，及其所擁有的應用服務也木會失效。</p>
                </div><!-- /.box-body -->
            </div><!-- /.box -->
        </div>
    </div>
    <%-- /.col --%>
</div>
<%-- /.row --%>