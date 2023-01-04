# HangiKrediCaseStudy


HomePageTests;

Case 1: controlCreditTabHoverElement --> Kullanıcı hangikredi anasayfasına gider ve header menüden kredi menüsüne hover yapar.
o “İhtiyaç Kredisi”, “Konut Kredisi”, “Taşıt Kredisi”, “Kobi Kredisi” ve “Kredi Hesaplama
Araçları” alt menülerinin açıldığı görülür

Case 2: controlResponseCode --> “İhtiyaç Kredisi” menu item’ına tıklanır
o https://www.hangikredi.com/kredi/ihtiyac-kredisi sayfasının 200 response kodla
yüklendiği görülür

Case 3: controlCreditSuggestion -->  Sayfada “Kredi Tutarı” alanına 500-100.000 TL aralığında rastgele bir değer girilir ve 12 ay kredi
vadesi seçilerek “Hesapla” butonuna tıklanır.
o 200 response kodla ve girilen tutar / vade ile liste sayfasının açıldığı doğrulanır

Case 4: controlSponsorBankSuggestion --> Liste sayfasında “Sponsor Banka” etiketi bulunan ürünlerin detay butonuna tıklanır
o Listede sayfasındaki “Faiz Oranı”, “Aylık Taksit” ve “Toplam Ödeme” değerleri ile detay
sayfasındaki değerlerin eşleştiği doğrulanır.

