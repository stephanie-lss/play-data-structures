package com.string.easy.solution680;

/**
 * @author LiSheng
 * @date 2020/4/4 13:03
 */
public class Solution {
    //    1、abdggba   bbccb b a
//    2、abggdba
//    3、abdcba
//    4、abdcdbaa
//    5、aabddba
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return checkStr(chars, i + 1, j) || checkStr(chars, i, j - 1);
            }
        }
        return true;
    }

    private boolean checkStr(char[] chars, int start, int end) {
        while (start < end) {
            if (chars[start++] != chars[end--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("klsaantowecjcflbenbvqbpcwqwdjqkoabnggutmufdoanehqjpuilhhkpwyoqfrirjnjaxfkhhvzcrfvttmplcmmaozoxtwyuiqfxciflbngmjrfrsvbjexknigqpydmirqwkajorlxmcrbpjpjsnqydekxzczshliuilwacdwvpgpurusvjxhjaesjrigrurkjmahpvvmmgindehhenslzdcjipydoiiiqhrrtlzfeajxwedhsjdsxsdzxcuxedluwulntgmqxknzoiwbgdyiofabdlceflnegqfuiogcfyptzbewwxohfefgrljvmeaottxsegrpvpugjxtzgpnqvlcnfvytwdhoulxoetbmxxvmsbuqnmvciovrsjvynfbgtkvzqiiawwnvjimwjwutotlqnnosgyugefihlvgktlgyhfwngpkvkrqxmbhlhoekvquajdhietjzphinpnahbbzyjrtprevbxgvesphvvokzjrxkdjksdjgfocyiulkvqxlnqdutehneuwfufiotgizpqncacynizdqqnirzhduivyroykiismqiyblivbwnaxdwxtavvfvaltjwftqnknvwcyycjrqndxykupjvydkiuzqqgilecayrfqmnhidiucutobazhxchydomjpuzgvtksxvlfgrwsajuyowiguxngvrdbujleraonwrxkdtpesxloyftsvksnpnprvkcicaywaltdpbxqgkyrfuhhpltvuitjawfftcflbwiwvxpmnpcsgzwqjqtrgkwuhzrezaplaigbmzyuxitotiqudspmsybhexqthqytbowqgwtsilejruirppswvfqlkxwtnujdblterntyqkmxqnzgxmkhdpkfxfjcyggrygpnszroqntdacbjdoluzvliowxwkkmnvvferkbfjoswnxvbakwbtgzbptweivqbomqmnkbukchrpipjfcagmiarfqtdpbjnwbysbcrxifwvvvlsbdspvoonzbpotjfjtvtakwbruzrqcbhuqpyjnhheovhmoemooincegopruvootaugneicjckjwfnufpxtuvitozhdycfbphoqghhdxfkbdcowbkfsoppzagjiawtmimcvvakhhvyjattapvgjdfmbceauowgazjrosruiytfokbnflozrxxecwggikblpvclgohtvhirllrndaujhookqbiihjpwdvsecowxyvghhiartoowvmxiqpojdreroisculxrqrnsymoummzcsudjvmgxzoljhpztqaufhmvjqmjbrbrcjvldnlvqzizfykqgkhjfnccnaegemejfmapfqwrknldyhuyuggozgbwzjrytooihldrgjrhgmihofvkpowucwzesiybxmblmmorhlfqonncczxofhpdkfucsmtffvgzhghugendcmluiyxsafzfycjfdqkutduxehrdwofpcqfshsgefrayoirjdixihdwojmaeezrdbydypqdqjxggiextuqrlegytrqpndxculxzsqrptqhwshcgokwlgmsykrthobxfppvuufbkpqsetkfxcafceibattvudyuysglkujfutidjthpzfbyurbesxdgmfukmqzapkrrybokwgfccmgsdmixsnfbyddcarlibxxoborenumzrwlptdrmryzvkftuyvqxymzyuidvhdfccfcghtvbmwuegixdvafuilphfypolbjlggdvutchurgzoqmoejewptgzdfkyscbzlpbijefbwwtbfyrjumrtaxrehwywrjgpgmcvyhzoqboamqisxotnoqcgomqutrrrrefazlalrltqmxiupixuqanjuocsujljkjxrmaktaxdbzqbecxcztxdegmbhqvdqxastttafeddoejctkafelwkworkeegpruajiwxfzjglqzcvcweiecvpizegmmvrobkbcaaytiompokjjbmcaayvwyircxrezfyinruddtfguxkbdytwzrfsjwqjvireabcebipchndsiqcmcknfwwxfsxgigjxlpxudktwwpadioldcgvfxyzsazuqasmwgzeusptcgzkynfcqcipbtygofhaiayvykvxrxcdauwvxrasvsrgxiutlholdiimldstptxkuwsugglxltpymyewxqbjthptjmbyjfzvkvhfhwfvcjfqxnaaskjktqyqgakoxthtwllqbnoctorsdlqxdszsyndrexzedwpcluoxvdyiktnwwjfksesqapymlputivtajodwcmcfixxkviikyhgnxfxszalbbbdsuqlurcymilntnuebfzaclodkalnkncduyekflyptqzfqmgeedaawlsjclvzkrwzjxvjuqmhidddudxhkefgvczajktofbetjlckgwtbwdkrngwjtbabyxzxrrzvgnpqehnrviqsqjhambgurksjftfpwaoomdfumxbkcdzzkkydcyltryyrzdfbkbubjjetcwztnhvegfynwqhkryowoxyfvbhirngmgjkkvdvfmugjefipofsmpahcukhwqxlrvaxzgcfqoiecvbyjujfskokxysycbprkazlznprlwnawgbftredntauaeigxiepdmasyzmhdjpztplaujnpckkwvvvckqcqqyxtyorkzenvnudnmoerpzyxrrutnrkaakhyflbwchrtbeajelcsqubtitpyzbitqxlmcssflyikzakmftwpazqycngpukzcmsskmvfrzjrbugoiotbgiwcecnwqgrtdlculhxupvyagqlqrkxmeroelglszpnjxgvkstrgbafuctyhralwipuyrsrtnsxzatmpccjpzhifbqfvrpptvhhwllmbcatphbgcwlgdtwnkunoklnyexeupwhhcqpoucxajlcvgslacieevbpjxomwknuyhzjfrrolyvhyowwxrhhknngmyayafbjparzfcuranjnoarzgjipptifslyqwssbbjvqfnmqhyfvreerphilrdzrwwuiecniqrqpgvfvtirkkzbgkxqdjxnufaerhfvptscbvbqczifuzdgccmddrzeluythrfobstzsjmgqziixfhatwbqpsysrcmawzzjgxrrpawelcoxdpbmjnkwzhdqrfotbivmakpbyvccjzzxagquxczpwmordemlgigclfwrchrmqhajldfldkfzfbngoysltapsjbtvzbjdjzpdjwoautkjozjkzlestuplaeicpblgclntixfnyuwthrjglatacmxhyuwfuranfabmlahumvsjrmnkiijtgxxrnjutthoxucppvvolmktclvkcykoncmptuzfteimkhopxqshlnkxejifbtflrqvrvkjrnwpyjftkymhrozvttxvhecbchkqtllkmeysjnvltzswgsoewmsdxwkpdtrmbzkrynqpirzywjoplfcnzolxzeqqrsaesmcdsitipxfknvngxbyrwvgcbiyfsxpyoqjkkjmxwcsbrgxreizgbuspqzgalmzcbvincbqywnqzerxtlpuawijjgxrtkmlpehvxxzniwrjejjqfedjjtoqahmnohtuhfutzcamcasilftltznjzthglqeuctqsvifqonctznsjawmnllcbuezogwqqrzafpadevlispmiotdorftyccygfackncscxhratqkacvhhkfjiypbtjbyavfiljglnxxigrtzmymdltshczrjohnraujzisfpnvvuoqlnkdujwcfrgbkqlqnppbwikxwresqkyxsweragiyixpcpvvjtnhezsiykxxlmikizqjkaewzjweoewsavfdyikgxttgnhgsnkgkspxccpblxtjouiadwnbbseavcamrdsjwiezubjsxrezgogfhyjukfnpjztbnsvtfheggyhlcgxpaddaqsutkdljkwkaaafxtvzoivhocktqmofzrhafxqoblhhjrpbcnyzsdkvkcmsoxazafosesjlnjyoettdwnmqkxdcimcbldmmqzspxhifojxjleairjcteaddonsfwcyhbfcyqxyicpnhahorooqoldioqpjbfcuaqqrrocfuwfbjuemqyqvpzuunprtiwdamuhkyybkiiuoojifadslwdhpzbunsfqxizizmdvakibucdxotvnwjgccjasfrriaxrqzmvkojpoqifohhlzrkxvhfebvordbxcpxrpdfybmmatctdsrqrlqzftbwjvenuhxhaifwoemophxqlmkhhtzbndjaplsjuqcalzawyequpslwmyubmwgwndiweplgeqitrhxztkbymcvtosuyvoxlmifinztgnuumbaspfwdozuvgowmtcxupbndgqxikphfddgpzunlmgtjjbcifbesbixapmgzzibvaiblhygmegcjbidgzkmiyugkjiyhguvxlkubbvkcndlelbwvhlibqcshaouwzqhgrlxlrtkutvjidblhelmoefqxtkurynagvktphmfleumxshgpmebvncvwroqvnbftioebhkbhbeuojblcwgfnfjfihlyxirslpjxpeggsruoexjljkgoshcuwfpuicemrpsdfvvkgncybiuinxdsbiezinaelixxrlyttrgyeatbtrhlxxraspltulbgqiydvpffhcnsusdukwtdsesamgkefppswjfmhgfgqarzptcuifepeafqzpdtbumnicborftrtzavajljcofrcdewcrqaviunzlgwzxpetxbnfsecqtokfmwmamluxddgyksxejxpuytbpfdyjyltidnobxhwoojdaxmmlkiodgpddtojnszzuhevdhwnliyiemkpgkasnlmlgqqfsxpdixpsqfgwhwaepbbztkybcnmrokccdysncdktjkxdoiscpawlanilxcgukkusvydbxoyvfwuxicwnksxffndtewxigzzgixwetdnffxsknwcixuwfvyoxbdyvsaukkugcxlinalwapcsiodxkjtkdcnsydcckormncbyktzbbpeawhwgfqspxidpxsfqqglmlnsakgpkmeiyilnwhdvehuzzsnjotddpgdoiklmmxadjoowhxbonditlyjydfpbtyupxjexskygddxulmamwmfkotqcesfnbxtepxzwglznuivaqrcwedcrfocjljavaztrtfrobcinmubtdpzqfaepefiuctpzraqgfghmfjwsppfekgmasesdtwkudsusnchffpvdyiqgblutlpsarxxlhrtbtaeygrttylrxxileanizeibsdxniuibycngkvvfdsprmeciupfwuchsogkjljxeoursggepxjplsrixylhifjfnfgwclbjouebhbkhbeoitfbnvqorwvcnvbempghsxmuelmhptkvganyruktxqfeomlehlbdijvtuktrlxlrghqzwuoahscqbilhvwbleldnckvbbuklxvughyijkguyimkzgdibjcgemgyhlbiavbizzgmpaxibsebficbjjtgmlnuzpgddfhpkixqgdnbpuxctmwogvuzodwfpsabmuungtznifimlxovyusotvcmybktzxhrtiqeglpewidnwgwmbuymwlspuqeywazlacqujslpajdnbzthhkmlqxhpomeowfiahxhunevjwbtfzqlrqrsdtctammbyfdprxpcxbdrovbefhvxkrzlhhofiqopjokvmzqrxairrfsajccgjwnvtoxdcubikavdmzizixqfsnubzphdwlsdafijoouiikbyykhumadwitrpnuuzpvqyqmeujbfwufcorrqqaucfbjpqoidloqoorohahnpciyxqycfbhycwfsnoddaetcjriaeljxjofihxpszqmmdlbcmicdxkqmnwdtteoyjnljsesofazaxosmckvkdszyncbprjhhlboqxfahrzfomqtkcohviozvtxfaaakwkjldktusqaddapxgclhyggehftvsnbtzjpnfkujyhfgogzerxsjbuzeiwjsdrmacvaesbbnwdaiuojtxlbpccxpskgknsghngttxgkiydfvasweoewjzweakjqzikimlxxkyiszehntjvvpcpxiyigarewsxykqserwxkiwbppnqlqkbgrfcwjudknlqouvvnpfsizjuarnhojrzchstldmymztrgixxnlgjlifvaybjtbpyijfkhhvcakqtarhxcscnkcafgyccytfrodtoimpsilvedapfazrqqwgozeubcllnmwajsnztcnoqfivsqtcueqlghtzjnztltflisacmacztufhuthonmhaqotjjdefqjjejrwinzxxvheplmktrxgjjiwaupltxrezqnwyqbcnivbczmlagzqpsubgzierxgrbscwxmjkkjqoypxsfyibcgvwrybxgnvnkfxpitisdcmseasrqqezxlozncflpojwyzripqnyrkzbmrtdpkwxdsmweosgwsztlvnjsyemklltqkhcbcehvxttvzorhmyktfjypwnrjkvrvqrlftbfijexknlhsqxpohkmietfzutpmcnokyckvlctkmlovvppcuxohttujnrxxgtjiiknmrjsvmuhalmbafnarufwuyhxmcatalgjrhtwuynfxitnlcglbpciealputselzkjzojktuaowjdpzjdjbzvtbjspatlsyognbfzfkdlfdljahqmrhcrwflcgiglmedromwpzcxuqgaxzzjccvybpkamvibtofrqdhzwknjmbpdxoclewaprrxgjzzwamcrsyspqbwtahfxiizqgmjsztsbofrhtyulezrddmccgdzufizcqbvbcstpvfhreafunxjdqxkgbzkkritvfvgpqrqinceiuwwrzdrlihpreervfyhqmnfqvjbbsswqylsfitppijgzraonjnarucfzrapjbfayaymgnnkhhrxwwoyhvylorrfjzhyunkwmoxjpbveeicalsgvcljaxcuopqchhwpuexeynlkonuknwtdglwcgbhptacbmllwhhvtpprvfqbfihzpjccpmtazxsntrsryupiwlarhytcufabgrtskvgxjnpzslgleoremxkrqlqgayvpuxhlucldtrgqwncecwigbtoiogubrjzrfvmkssmczkupgncyqzapwtfmkazkiylfsscmlxqtibzyptitbuqsclejaebtrhcwblfyhkaakrnturrxyzpreomndunvnezkroytxyqqcqkcvvvwkkcpnjualptzpjdhmzysamdpeixgieauatndertfbgwanwlrpnzlzakrpbcysyxkoksfjujybvceioqfcgzxavrlxqwhkuchapmsfopifejgumfvdvkkjgmgnrihbvfyxowoyrkhqwnyfgevhntzwctejjbubkbfdzryyrtlycdykkzzdckbxmufdmooawpftfjskrugbmahjqsqivrnheqpngvzrrxzxybabtjwgnrkdwbtwgkcljtebfotkjazcvgfekhxdudddihmqujvxjzwrkzvlcjslwaadeegmqfzqtpylfkeyudcnknlakdolcazfbeuntnlimycrulqusdbbblazsxfxnghykiivkxxifcmcwdojatvituplmypaqseskfjwwntkiydvxoulcpwdezxerdnyszsdxqldsrotconbqllwthtxokagqyqtkjksaanxqfjcvfwhfhvkvzfjybmjtphtjbqxweymyptlxlgguswukxtptsdlmiidlohltuixgrsvsarxvwuadcxrxvkyvyaiahfogytbpicqcfnykzgctpsuezgwmsaquzaszyxfvgcdloidapwwtkduxplxjgigxsfxwwfnkcmcqisdnhcpibecbaerivjqwjsfrzwtydbkxugftddurniyfzerxcriywvyaacmbjjkopmoityaacbkborvmmgezipvceiewcvczqlgjzfxwijaurpgeekrowkwlefaktcjeoddefatttsaxqdvqhbmgedxtzcxcebqzbdxatkamrxjkjljuscoujnaquxipuixmqtlrlalzaferrrrtuqmogcqontoxsiqmaobqozhyvcmgpgjrwywherxatrmujryfbtwwbfejibplzbcsykfdzgtpwejeomqozgruhctuvdggljblopyfhpliufavdxigeuwmbvthgcfccfdhvdiuyzmyxqvyutfkvzyrmrdtplwrzmuneroboxxbilracddybfnsximdsgmccfgwkobyrrkpazqmkufmgdxsebruybfzphtjditufjuklgsyuyduvttabiecfacxfktesqpkbfuuvppfxbohtrkysmglwkogchswhqtprqszxlucxdnpqrtygelrqutxeiggxjqdqpydybdrzeeamjowdhixidjrioyarfegshsfqcpfowdrhexudtukqdfjcyfzfasxyiulmcdneguhghzgvfftmscufkdphfoxzccnnoqflhrommlbmxbyisezwcuwopkvfohimghrjgrdlhiootyrjzwbgzogguyuhydlnkrwqfpamfjemegeanccnfjhkgqkyfzizqvlndlvjcrbrbjmqjvmhfuaqtzphjlozxgmvjdusczmmuomysnrqrxlucsiorerdjopqixmvwootraihhgvyxwocesvdwpjhiibqkoohjuadnrllrihvthoglcvplbkiggwcexxrzolfnbkoftyiursorjzagwouaecbmfdjgvpattajyvhhkavvcmimtwaijgazpposfkbwocdbkfxdhhgqohpbfcydhzotivutxpfunfwjkcjcienguatoovurpogecnioomeomhvoehhnjypquhbcqrzurbwkatvtjfjtopbznoovpsdbslvvvwfixrcbsybwnjbpdtqfraimgacfjpiprhckubknmqmobqviewtpbzgtbwkabvxnwsojfbkrefvvnmkkwxwoilvzulodjbcadtnqorzsnpgyrggycjfxfkpdhkmxgznqxmkqytnretlbdjuntwxklqfvwsppriurjelistwgqwobtyqhtqxehbysmpsduqitotixuyzmbgialpazerzhuwkgrtqjqwzgscpnmpxvwiwblfctffwajtiuvtlphhufrykgqxbpdtlawyacickvrpnpnskvstfyolxseptdkxrwnoareljubdrvgnxugiwoyujaswrgflvxsktvgzupjmodyhcxhzabotucuidihnmqfryaceligqqzuikdyvjpukyxdnqrjcyycwvnknqtfwjtlavfvvatxwdxanwbvilbyiqmsiikyoryviudhzrinqqdzinycacnqpzigtoifufwuenhetudqnlxqvkluiycofgjdskjdkxrjzkovvhpsevgxbverptrjyzbbhanpnihpzjteihdjauqvkeohlhbmxqrkvkpgnwfhygltkgvlhifeguygsonnqltotuwjwmijvnwwaiiqzvktgbfnyvjsrvoicvmnqubsmvxxmbteoxluohdwtyvfnclvqnpgztxjgupvprgesxttoaemvjlrgfefhoxwwebztpyfcgoiufqgenlfecldbafoiydgbwioznkxqmgtnluwuldexucxzdsxsdjshdewxjaefzltrrhqiiiodypijcdzlsnehhednigmmvvphamjkrurgirjseajhxjvsurupgpvwdcawliuilhszczxkedyqnsjpjpbrcmxlrojakwqrimdypqginkxejbvsrfrjmgnblficxfqiuywtxozoammclpmttvfrczvhhkfxajnjrirfqoywpkhhliupjqhenaodfumtuggnbaokqjdwqwcpbqvbneblfcjcewotnaaslk"));
    }
}
