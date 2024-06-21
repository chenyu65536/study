package com.rain.leetcode.medium;


public class Q3138 {

    public static int minAnagramLength(String s) {
        int[] charCount = new int[26];
        for (char ch : s.toCharArray()) {
            charCount[ch - 'a']++;
        }

        int minCharCount = Integer.MAX_VALUE;
        for (int c : charCount) {
            if (c == 0) continue;
            minCharCount = Math.min(minCharCount, c);
        }

        int charKind = distinctCharCount(charCount);
        if (charKind == 1) {
            return 1;
        }
        int minLength = 1;
        while (minLength <= s.length()) {
            int startIndex = 0;
            int endIndex = minLength;

            boolean isMatch = true;
            while (endIndex <= s.length()) {
                int[] char2Count = new int[26];
                for (int i = startIndex; i < endIndex; i++) {
                    char2Count[s.charAt(i) - 'a']++;
                }
                if (distinctCharCount(char2Count) != charKind || charCount[s.charAt(0) - 'a'] % char2Count[s.charAt(0) - 'a'] != 0) {
                    isMatch = false;
                } else {
                    // 判断比例是否相同
                    int repeat = charCount[s.charAt(0) - 'a'] / char2Count[s.charAt(0) - 'a'];
                    for (int i = 0; i < 26; i++) {
                        if (char2Count[i] == 0) continue;
                        if (charCount[i] / char2Count[i] != repeat) {
                            isMatch = false;
                            break;
                        }
                    }
                }
                if (!isMatch) {
                    break;
                }
                startIndex += minLength;
                endIndex += minLength;
            }
            if (isMatch) {
                return minLength;
            }
            minLength += 1;
            while (minLength < s.length() && s.length() % minLength != 0) {
                minLength += 1;
            }
        }
        return s.length();
    }

    public static int distinctCharCount(int[] charCount) {
        int rs = 0;
        for (int c : charCount) {
            if (c != 0) {
                rs++;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        // int rs = Q3138.minAnagramLength("abba");
        //int rs = Q3138.minAnagramLength("uyjweidsctjujsinjvekryriegckjhlyoiawvkyandrummmssqsgbbwwwaerlnxuqseukjjvmnsctjxzegptjxxmyuqcrilsseqdygmbuyogsxusazzexvzjbceroxaeozdirzgwvwiahpxuevlxzclsjiidlxarnkuyosxsvuefmaebjdrcxcoqebqdoggbzqqqghcugsypaogvdgutkhidsfzxlbjnwbtxuylzlkiisflvbzlggfajxiohqplcqwlmktifrzhesdaboerukizbjtibaghyyeqyafgogsgbdpbtxaejdwtxspxsfskakingoxykwofloipkutwbizhjzgvuwmcvezplpjynvscnrafeithhtqwjxeonrrdihgmcoxneuuvdgqxmkvucbtzjcnwpbtkoonttmxqdmhivsndhdnbzdcrtyerokguunntbflw");
        int rs = Q3138.minAnagramLength("nqazgrrkovypkksgsdgqmoudzsnqjnkylnjucoyjcskgdsutmmckuaesggrbuvccjfqvdkonndoznnwzqgxkojwyzdqoosknyzsgprzuyxmcayvjfaxywkiclnmrmmfgeewdfrlwbjiveuwadzwlftfqymusyxkgrnizvbtawhlikfiqnolqyvntdzeiywlglgfvqgvmnsaaqolgxerpjaepxwqihyyzgtzfcledhhxspelmmsjqnemsnlblboyymtdfkimumjmchxfiaewyxhgbawlcpjeufcgoukawgguetpyqjijgljnpkewkpajdtbyeqdjbkwqsecjnryboxipphsfvdrwbprkkmyrdpesaccpthltikpbcsbdxokggqirizunrcaepgngjjmtmxqutvsdztylcxskffklbncecscgmtsiyzdxnllctppzixlmgorebhnxhivwparsslnuzcclrbdkvqbmdfuxkqilvyerpnzdadvhzstvgzjtwvztwqapynevvuplgfntubnwqvrxkeqrlysbwbqvhwjyvfkliqwhwzhugbtwrcsjvncnuqelwqczsjxtexlzagmrzihbkdlqchyyumuqrfxtaehaqpzftbhqnpxltqwdelyppageuzlmmzboynkapajtbjudobqfcegdaoaaxiqerguqvcpjjjiwcsnawyakgwhxkbkkramtbctolrvhyiceibxkjgxmsbbwinrtipafrolougbtkysczktdiwprszsqkhezrvxzlscbiqqbrxmyqgdjjhwksskacfjrxtnqaquekagkzftfeztkpemaqeyogjkpavgfemfvkefttjhscusvoxtiibqtxsxcxlttegnxgeginlnwcoujltoedywxfwhvogpuxbxoyasjfvmunzdlyvghlvtjjshgrphlcvzrxrijnnmocyukkdxuqfsdmerjdkrikoiksukgonfefjnnykaycqxgsozwyeyhshjqsqhydkawlvcjpoickfujjjilfussebdsqauuwiddybftoprzcvmsmnwcceaaiuhptaufudebwowynctapgregphfyenmiztwgfhnhptejqzqbpyuyzldgovezlcpiajbwpkmaekndmfljwouujqqrspbtszslbubqojrwrgossriiywzhcgelgukuxvmaajrepdzkqvaohpeoeyjbnrjdcaowprqzcuocgwefjlayqesjcxebsijiuycdqxlqtjimxabzdhvtbchjtncjuvhkanbzzpylltsyobckgujjfoalsxddtjkyxbdhhyraznwhtmwmosahdmitaiazctxqzlbrpmgfktvoumruqtioziowchzyezghaqilibobxfsmujgtzfnspykwyynpsbvsvaaifhzxpxtfpzlevigkxejnymasxulfqpgqwaolkrcucqpuyvpnswjkweobiqnrexggtojfaalptbdowkmzlqagzsnyqcbgqclpwarzyafmchenuuqvgkqsfsdnldrqkozgmgrcxebqjcuwfipgthwotsmmohjmhqlsgtytzooaaamiombkqtnrsytspjekupymzulxbicuixiwyhhahkoivlajcbsykbxfjhpskmjsrdbmzltjelbdomckqeikymezztyueelcmlgalentqhlpcpxgeqoclxacjysqjtwgpwacfgpfyiuucvdnzcceeefcjyljkiqtdisijljlkmgwvumqaitzwmqpdbashexxyrrdeukglehwbyxkahgbbxrfkacxukcwcnglwfnttnyrvyusescvsrleluqevviognhgucgvdyisgaxjmcnwnfelswrexkpmfsnizwstgoclapgklecljhweqqqgrtpjzmjydeehnzbuprbmxrqrzakwxecksisuzuqyhpapdbhdeggteblsbcstuacrtorcfxauyyruigmvfjkkuotfwrdxaazvatraajujnztedkkajajxjkyxiphrbkqytntsecwsjpsbbawzzogsqobxwehatejjeiayvktozzyxcpuggfhrkklzgwdnvywiwfowkiqyiawenitornkkruunwwwmhgclxechxaqqhtzcejovclmiiygjjfdrftsmnoylngyainbofqrqzcjrnxvhbfcreniuyjrxvyuzuqkldjpjgjyupiydvmuhcesohywqsagcdgjqaepftvkhpktczvliyzaujexvbwojrtbcknllkhsooddvblbgcuykecgvnwdwlyqslfsuysjmzjhdtxjxjjekejnzkdqqnopvimspsqmsrerqnmcfgsgdcywzradngubeuihpaunaxgauomvkqqbzgyloniszksntzgutvizhjrkhvrvsnoviwypvbmefyxvldodfajyjdfgrmgqfsmwptdrmmukeqtngxbhjuzqsjpdjpfqclqsrwzblqnsmfkeowioqcperyknzejdqfktmgllnjatcykcowsivdkvqrbtwjyknoqtkqdvodqgbrhahitruszcnywpzaycbzoderhpljibftvowmobrisxqyfanfmcvjdhnzwizotxycbxtblehmzxwzhbhbupiulxvdmafpewldocmkdqetxuxbdzackcxlwuwefutnfidorgfaqmeobvhjsoavupstdjytlzjssnbllzkhjgzgcgpznpyzrpbkjdwgpkuatbxnditkzqdxtdigprnytuzsgbkmletkjdtnwhegpnlnlfpdfapothuwctbirkbbgahoatkwfzjobiqxnurzrmmeakwzeiaaktwgednjawsusplgfhfcellglifisgbcumiwifoebgicqxejclqhnjjkuenwdubpqojfjjopcnhneymtjhycshvofbcmbqkalcwjyjtbrkxoazlyoxlpkiegheonmbyetnhqwfdgxocbtnjohrpskglcokllkhcpklcgmjsfxjrbxkpaftspukkrsgjaooqceieowqpbzpuctiidyvfuqxtymwfhcoktvvynqzzjbhetasrzhvsqhocemyennybimgqigmsialwkwlurodpozrxdktphbjsyzwasxjcwigbsiwrtglcnaglttuavuwydareyyazaazyckxeuazfeutdycycljfcyelrcfqjkunriqfndtgjlqkbzvvzrjqbjvhwqvvlattxuafwgqbnpjhwdvthdmetynrumxiwnzrbvensyjrjjuicasqsxeivueflpyekougpctuvsgudguungdkjnhggbgseqwvzxxdxmtvhggqoywdgeexcqsylmllipxleduwlsqcsfkmnopidbtjgimggjjpiiostkxekusjvzyztaskyburtqlhnavuqoxagdceqytymmoavcjrliwlzcldvfcbbqdzahuhouzjqeypqbcztcjodtwpyxzjsichtlqskobxajspozjipmrpxrcbbkkdlvyzbdfemrvtamahssyplqxkuqardaljzbtrodtqprqcfnzrwywbswhxngysnauqbppmenxorxrfqqflkqigmskgyhdeqwgsedxgyktpsydktexuixekjupzmtjkpgjnyoqnoawuysetrdqvnadogkdkkkscsxdevrxkaoaysnevgpcxmscsdegmqqoqfgwikkmxvxyrvtdhigzycfpsudltrrudlxipewtrdaocjthmzkopccnhalxjzentdlvwuslzxiwbvuyepybivktejwzhdeepztitqhubvxiktjpbtleqqavkvngokkbncizcsxljyqfmcmnzprjkqfyzebxavqzvxywaplmvufmgjsutscnchgdggczifaommydsvgnwmhnibqhjweqplxblhqigaysxvbtzgnsjvswhzsdrcawuawtukwrpuvlvaccgnfrjfylirapdqeelkogntrlnwsouioahmbnakqwwbdqbyedhznzrrfhumqjmjlkajfkqowpfzkaztauuminxjzjrgonjlmkejcwfigigmelmkygfrpcxzqjueyaosffssybnsyzyccqopzszajnhzuyearuwwidjfyhsrziyfmwcrbbrypznmciynsbbteagwmygrddytujwvtyhecqtnkabwjhaiogpedceuvzxtppftgudizfragzitckobqwzgrgaocbriknoijmcvrqnjsxzwnaezgldwpvtwucpwlpujejzxdqcolgrocdubqcwhvtglssrrrriupcasethtjnuggdbuaurjzpyztpkxihqksqgyqozwfgscesspxrdxpptudkeyqljptswpkomqmqxchnahzzohblkxnvfgdaommlwlotjpsdcnzdtspwwxpykwftdimcfeicmoyzqobceylbfxogtxfrnrncqoqswjfetykspekzwvhjraqixqdtslivarcnbqumlzblytlibioanxclbilnjywqewdublauqghjntencyrjralmkinvjrpwfgfzmnfjckwbfigmyjoktwntdtgvrqiyicramykfnszoagybjpgzfsslmhseecnhjsemilkzictaejiiiszznxdjetxrbqyhlgkuhwywegrqjpqnuqwucnjzajrvkjnmgszuytrxdmhkxctbgkzckqkxlimfnscedjcgtfhlvtotqclwjvkrvwhxvcubaucwembpuxkevyzpyswubdjyelmmrpagfscbouuckyydrduemyechdxoraakiqzoznejhqnfpmfxqgafblibgpkysxecfukepsjeipwbcuoqqyeojtrcbyrhdjqkrljdeqnkdyfjyykgkkjkgsktjuudsymeprnjeitssrtdazxlhaccsjilgcisxbsyrsqvmaxvgvxoiupmsaoyfxjdyrvumuppvloiyyshepcmrdtutfiheshkqyoefqsgynrjjzyubvexzfwhwqztgubwoagimrskiypzcsnxhrkzaoffjzvhvymdhnqhcnaxdaiojznkayxinlfuwymgtefadlatwwyqhscjqlxoaaqtlwczlzibqqabejaepkgyyarwqxnrsmectfnokbvcbzkioqacveqvaoohdjvxcuchkyedozzogdjxybkeydtqbxaetwzeeuxkjlewdfacowwjzhmduxnsmsslngjstybagaqyfserpslulaleqmzvmaesgoipxnljkvlqgqonwagiwkksgvkekhlbymgddjlrqovkinpqzmgbrudfpkuvkfbzbmuhigdaqmpuvoodwzyqumfwiqprztgaxisglttnlhplxoziklzvantqubwltkvwwhkzcqawqdltfmjhamoktpjpkbebvbxgjsfwuxjgvfjppnszkyngmcphhxtbbvackufhbtelfnigptjmjgngdkwsxclrcdnaalsiueqzefggvejolsvscayztnxlsbvhujrbcmjhlnyeunbuprozhuknejdbmwtzszdudetibwskcuhggaewojozyfdpaatcwwkwszyaxqeobayawjnqjvuybzgehuzzexwxufkaippgnqxmzoytmshgnrqlcettkcwzfrvtxzejcuqfvjnsyrmyyunmqisqelxiuugutngmzwkbwsdxbtufsvzqkaeaogwjlydtzyrzevrxuhgkubftqycjafszeyhrlfeajilxqoqyuvuafykqbqbawgynucxcatztvxhjudqmdlwedrthxpeybouaikarbeicdmoqisghxcpprdsyiwirsuyknugxjknidgfrntkxbcsskavvsqbsnaifuqgblojctfdpklnttkccpjpqyimxxeglplfeessemyvysfdpkhsowqkvmqswrvfqdsehmkncxolrqqretozpysyouusqkqsetiluqpbqqcykppftujyxbkoybyrrdmzifsbtlggxojnrbqasxhvizjuhqicpfbhlcyucrcmkitndajdowxacetgbqxgozwsnkkayjewayuyccsnemdojcpgwzorjtqnyjvqvhjphbuxadncidwyrasocpzdgjkmjeqnmllrlwgjjlqndmyzjxlwrrgzkvyluexbcarjqylcwwvolgpepwyfginvehhhylihanolkomjxnyydjmekpeczuqzkktkgkletvzikarakvaxjaitsetbktkypqzmmkysnyhnatthebglcmdtleajgrwcunpjoliysvqbaukimngoywhibvaisqnwzldlufdgboiwhzplkrxefvnclcmwqzfjzjaocsxqghzzovymbfpolzpocjblkciccrcmzthtjqcctxwvonvtrdwtfowjyesdnqiifgpwhelyngwwchgksbgnrdzivsoalzjtsmsnldthnluhmqgmcpvtoikutejrfathndmuxgqosmrsadphahzgaphedgeuixhaystvgklouofdmicgnxtalgcuiphkjxqjjitekfgpdbjiqslieeuggmyfgprqswmfjsdswwzotnstdnntsclxxhvshgsfrkocorzoqpxjpeuupskeybvoxmojknatxidbawjimykidryynswrsgnycfwngkpkddpjtpzcfutlgumbzzdlkebkcezbfyrznjrtnlauufghipoueozwakjlhbvkncnlstkjzphxcesrcejlfadwpmepbhlgiuwivfwwvhlqmmajirkeajjhsrqutamcqfzzkvcrbcfsqabggtwukmjgsbfjaijjwjpdmgoplqepfodrxeblvbbynyeaibajqeccrqqgivvmzrxbzhqylvnrxgvfuavfaxpcxbobkdjzvbdepllguxaewrrmtnqzzbqcxxllaandrpcjiefitglkqccnzqsbqiknpyynsygflnqwhfvbshqqqgkfgesnasgqqksefatpnwutuzaejdkaajaxsfrmakpywsyjlwepvwuanwtsbsvfjozpfynmnjwnxfvbyxnljwurwsigpnxysrgugrtynntcqzkkramiwhjzcqnulxufnjzaettkkrikkrschtojcoafeyxdcowqhxuhtgwuagiatyswwyfuzjywkscaxipzffszxcbddlgolhcbzsvgaovvrthywgzzprusrboddjgovlnghrrtekystgsvdspxzxtmlhphmbewadepzakvewpheqihbhtfkqvfbeujijdniwboqxqtghcubjvvdgkjnqtildkxlvvbccmadvszsyefzzugtozzgptvelxdrjymarjxpjamsaozsltnxuzoukjectsojltjzxebtkijtroqwkauvccjnxyvhoohokimotkpwcgiacttlukgljhycekgtnwnezxvxqjjtpmxuqqzrpgkxaywydkduvvdvekqhgkwbudqhizbpdggnaucujpfmxxqczkemgcrmoqnwkhnqzowzuitiiyzqlrkbmyswnayonrnbqasvcpbobmvuypxtqntlowbqgyfxslewewegsiucrnrlsjjuzopipgxcxxqwkmvxyayjgkznqefuwaqvaamzjeksbinpqcwqljflrptmgsryrfdntacpbodnulitnxyhkspmqgsyibirnreragpsxjdlfggmgbjcjazdqjlbucjjqcgnudetxkghepadmdbapgvmjunuksrkiclobswuligvsrqqzhqyoxmhbszuhkdlbecvddalyzynmflcknumqgdhqflondlecsmokbcerrylumumdqpjglnhtmzmwoykcymsyotvrtjjbxioytwkmcgottojjbqcjfflspdznjlnmavstzbgyntmwgclcwbrokswpixfcvgswclosejewlvlbaketyxuplxriseckseblkqfjkkjdzpfeekahwkfhkueepgavmuudejxtbdzcqnjrjpmphbbqpfgqimxacekfwsqacibcjeiqeebybqatyiohddapdqtyzxpiyooolemjgshyycgdubxweokkreohvbeukfdzzatonpfsyexbqmilsfyryivapfzhovezzdvliajyvvqpskletclnoacdpizerthdhbsqiqzbojumwohhzpeygdgxmearpbwnlxmzicgjfzpywaregjftirjmkyyuwnfdzsyliulftaltwdshuqaiwzbmgumciurzrjhccatkwjlrebdihrechuierakihucqmirjvucgwarlonygytyfsfsruifklicwrqvpcgngnnrbdjyhxolqejsokntbybbyyfqzsigoaatrjyjezllxtcmbulhjaskgcipyoxjcrupsinxegzgjqltkurwqwksanajpgwkpokqlozaggnuknfrbynvkcokwaeozjidfiamkjkxedotgothccykmpctprrkyrssdrpgeviibnaflekokiesozefzpknzangcegdtdjkquqevnybajlblecxgqztqeskiwoyztrmkqvtgvkqjjjvnjzyazpddjerabqplzqeenaubfftdscpxzzuvjgllfqcpkqvuaerqiqwdxzqbylxwihnlzntwxvirjtnzdqvxsslpesasgcespemnyqvyhoarchuquiikgvbxzfwxeihjtvhsccqxcrzfswwmqeqaqllgsvbnasiartnseywcmswbiuwtfkfnnbpkegsfkhexjojseufkmcpiyjzeiyizuyezgvmeypyiqusytkupbxdyzkwaafunsuefhgalruvxlthkntdtcehhyzvwszopchroqfktkyvizesskrqgdlcokkbzzohfjxbywuguccgbxifypnazsiouulxowvflooguoecnazwatqeccckmzsqosmzwubkzghcxyylwnatpzanuewvksegihmuhmtseyavypnlrckjeiaxoxqyqawmdcypqmuisubvbdslucxowxmwjknpgyntlthkgmkhwqhukacamumswtoicsxhutmjgisngulocghadgejsagwlrvkzlytwjjltdblkotmzjcghcnyzjkgtnlidtbxlmenpdumesamifysnyvuudmymrdvqdwbkhjlerfurntdizdbhdwerjdmaftypswdnajzxwabfojlofuiiyxddpmzeagfnidbgumebcmsqbjdgupsrcbykgkxxjmyojkzwgslrzkjvpejajflusawiyqhfqilwbqrkjqljflwgfbcwcdqzisepttfmzeaauzixxianqmrrrmrcpfdmvwcphbbgvajztyenbymbxklphxhpqakbbgpuhnlqlhfcvotakrzmwfjdyfntxzorlhxrgbayovewkrbxbtkwuavjdblmqdetnsvmjrzcgppqkqqxccxistnbnbhxrdgelzzjuhiorsstgeqscdjppjpqzpajjzlrhposmsthwvxaksbtbdeietvawrlflihqfoqjmgvjyejvqktdcdlnlocpyyiwgxyuuujvhvgozhdueajouitorvtnamcuytbpecgbhcdwstpgmqpeyayfmsgcmlkfifqbqstfywrcfrtajygjuenmjdsroodrdoqptwwxgpnjcvoctrxnhchdxywvgjxlqnhgolayqw");
        //int rs = Q3138.minAnagramLength("jjj");
        // int rs = Q3138.minAnagramLength("pqqppqpqpq");

        System.out.printf("" + rs);
    }

}
