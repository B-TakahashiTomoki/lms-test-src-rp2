package jp.co.sss.lms.ct.f02_faq;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;

/**
 * 結合テスト よくある質問機能
 * ケース04
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース04 よくある質問画面への遷移")
public class Case04 {

	/** 前処理 */
	@BeforeAll
	static void before() {
		createDriver();
	}

	/** 後処理 */
	@AfterAll
	static void after() {
		closeDriver();
	}

	@Test
	@Order(1)
	@DisplayName("テスト01 トップページURLでアクセス")
	void test01() {
		//トップページに遷移
		goTo("http://localhost:8080/lms");
		//遷移成功チェック
		assertEquals("ログイン | LMS", webDriver.getTitle());
		//スクリーンショット取得
		getEvidence(new Object() {
		});
	}

	@Test
	@Order(2)
	@DisplayName("テスト02 初回ログイン済みの受講生ユーザーでログイン")
	void test02() {
		//ログインID入力
		webDriver.findElement(By.id("loginId")).sendKeys("StudentAA01");
		//パスワード入力
		webDriver.findElement(By.id("password")).sendKeys("StudentAA01111");
		//ログインボタンクリック
		webDriver.findElement(By.cssSelector(".btn.btn-primary")).click();
		//コース詳細画面に遷移チェック
		assertEquals("コース詳細 | LMS", webDriver.getTitle());
		//受講生ログイン成功チェック
		assertTrue(webDriver.findElement(By.partialLinkText("ようこそ受講生")).isDisplayed());
		assertTrue(webDriver.findElement(By.partialLinkText("さん")).isDisplayed());
		//スクリーンショット取得
		getEvidence(new Object() {
		});
	}

	@Test
	@Order(3)
	@DisplayName("テスト03 上部メニューの「ヘルプ」リンクからヘルプ画面に遷移")
	void test03() {
		//上部メニューの「機能」を展開
		webDriver.findElement(By.cssSelector(".dropdown-toggle")).click();
		//ヘルプ画面遷移
		webDriver.findElement(By.linkText("ヘルプ")).click();
		//遷移成功確認
		assertEquals("ヘルプ | LMS", webDriver.getTitle());
		//スクリーンショット取得
		getEvidence(new Object() {
		});
	}

	@Test
	@Order(4)
	@DisplayName("テスト04 「よくある質問」リンクからよくある質問画面を別タブに開く")
	void test04() {
		//よくある質問画面を別タブで開く
		webDriver.findElement(By.linkText("よくある質問")).click();
		//タブのハンドル取得
		Object[] windowHandles = webDriver.getWindowHandles().toArray();
		//よくある質問画面タブに切り替え
		webDriver.switchTo().window((String) windowHandles[1]);
		//別タブで画面が開かれたかチェック
		assertEquals("よくある質問 | LMS", webDriver.getTitle());
		//スクリーンショット取得
		getEvidence(new Object() {
		});
	}

}
