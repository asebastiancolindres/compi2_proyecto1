/* The following code was generated by JFlex 1.4.3 on 18/03/14 10:43 PM */

package parser;
import java_cup.runtime.Symbol;

import java.util.LinkedList;



/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 18/03/14 10:43 PM from the specification file
 * <tt>scanner.jflex</tt>
 */
public class scanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\55\1\55\1\0\2\55\22\0\1\54\1\0\1\25\3\22"+
    "\4\0\2\22\1\27\1\20\1\2\1\35\12\1\1\21\1\22\1\23"+
    "\1\26\1\24\1\22\1\5\1\15\1\51\1\41\1\36\1\31\1\52"+
    "\1\43\1\53\1\32\2\3\1\46\1\50\1\34\1\33\1\40\1\3"+
    "\1\42\1\30\1\37\1\44\1\47\4\3\4\0\1\4\1\0\1\45"+
    "\1\51\1\16\1\13\1\7\1\52\1\43\1\53\1\12\2\3\1\46"+
    "\1\17\1\34\1\14\1\40\1\3\1\10\1\6\1\37\1\44\1\11"+
    "\4\3\65\0\1\22\16\0\1\22\21\0\1\3\37\0\1\3\uff0e\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\6\4\1\5\1\6\1\7"+
    "\1\10\1\11\5\4\1\12\2\2\2\0\1\4\1\0"+
    "\2\4\1\13\1\4\1\14\1\4\11\0\5\4\1\2"+
    "\3\0\4\4\23\0\5\4\5\0\4\4\2\0\1\15"+
    "\23\0\1\16\4\4\1\0\1\17\1\0\4\4\13\0"+
    "\1\20\12\0\3\4\1\21\1\22\1\17\1\0\1\23"+
    "\1\4\1\24\1\25\25\0\2\4\3\0\1\4\1\26"+
    "\1\27\5\0\1\30\15\0\1\31\1\4\1\32\1\0"+
    "\1\22\1\0\1\33\1\0\1\34\1\0\1\35\1\0"+
    "\1\36\1\0\1\37\5\0\1\40\2\0\1\41\1\0"+
    "\1\42\3\0\1\43\1\0\1\44\1\0\1\45\2\0"+
    "\1\46\1\0\1\47\2\0\1\50\2\0\1\51\2\0"+
    "\1\52\1\53\2\0\1\54\1\55\2\0\1\56\1\57"+
    "\1\0\1\60\2\0\1\61\2\0\1\62\1\0\1\63";

  private static int [] zzUnpackAction() {
    int [] result = new int[270];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\56\0\134\0\56\0\212\0\270\0\346\0\u0114"+
    "\0\u0142\0\u0170\0\u019e\0\56\0\56\0\56\0\56\0\u01cc"+
    "\0\u01fa\0\u0228\0\u0256\0\u0284\0\u02b2\0\u02e0\0\u030e\0\u033c"+
    "\0\u036a\0\u0398\0\u03c6\0\u03f4\0\u0422\0\212\0\u0450\0\212"+
    "\0\u047e\0\u04ac\0\u04da\0\u0508\0\u0536\0\u0564\0\u0592\0\u05c0"+
    "\0\u05ee\0\u061c\0\u064a\0\u0678\0\u06a6\0\u06d4\0\u0702\0\u0730"+
    "\0\u075e\0\u078c\0\u07ba\0\u07e8\0\u0816\0\u0844\0\u0872\0\u08a0"+
    "\0\u08ce\0\u08fc\0\u092a\0\u0958\0\u0986\0\u09b4\0\u09e2\0\u0a10"+
    "\0\u0a3e\0\u0a6c\0\u0a9a\0\u0ac8\0\u0af6\0\u0b24\0\u0b52\0\u0b80"+
    "\0\u0bae\0\u0bdc\0\u0c0a\0\u0c38\0\u0c66\0\u0c94\0\u0cc2\0\u0cf0"+
    "\0\u0d1e\0\u0d4c\0\u0d7a\0\u0da8\0\u0dd6\0\u0e04\0\u0e32\0\u0e60"+
    "\0\u0e8e\0\u0ebc\0\56\0\u0eea\0\u0f18\0\u0f46\0\u0f74\0\u0fa2"+
    "\0\u0fd0\0\u0ffe\0\u102c\0\u105a\0\u1088\0\u10b6\0\u10e4\0\u1112"+
    "\0\u1140\0\u116e\0\u119c\0\u11ca\0\u11f8\0\u1226\0\212\0\u1254"+
    "\0\u1282\0\u12b0\0\u12de\0\u130c\0\u133a\0\u1368\0\u1396\0\u13c4"+
    "\0\u13f2\0\u1420\0\u144e\0\u147c\0\u14aa\0\u14d8\0\u1506\0\u1534"+
    "\0\u1562\0\u1590\0\u15be\0\u15ec\0\u161a\0\56\0\u1648\0\u1676"+
    "\0\u16a4\0\u16d2\0\u1700\0\u172e\0\u175c\0\u178a\0\u17b8\0\u17e6"+
    "\0\u1814\0\u1842\0\u1870\0\212\0\u189e\0\56\0\u18cc\0\212"+
    "\0\u18fa\0\212\0\u1928\0\u1956\0\u1984\0\u19b2\0\u19e0\0\u1a0e"+
    "\0\u1a3c\0\u1a6a\0\u1a98\0\u1ac6\0\u1af4\0\u1b22\0\u1b50\0\u1b7e"+
    "\0\u1bac\0\u1bda\0\u1c08\0\u1c36\0\u1c64\0\u1c92\0\u1cc0\0\u1cee"+
    "\0\u1d1c\0\u1d4a\0\u1d78\0\u1da6\0\u1dd4\0\u1e02\0\212\0\56"+
    "\0\u1e30\0\u1e5e\0\u1e8c\0\u1eba\0\u1ee8\0\56\0\u1f16\0\u1f44"+
    "\0\u1f72\0\u1fa0\0\u1fce\0\u1ffc\0\u202a\0\u2058\0\u2086\0\u20b4"+
    "\0\u20e2\0\u2110\0\u213e\0\56\0\u216c\0\212\0\u219a\0\56"+
    "\0\u21c8\0\212\0\u21f6\0\56\0\u2224\0\56\0\u2252\0\56"+
    "\0\u2280\0\56\0\u22ae\0\u22dc\0\u230a\0\u2338\0\u2366\0\56"+
    "\0\u2394\0\u23c2\0\56\0\u23f0\0\212\0\u241e\0\u244c\0\u247a"+
    "\0\56\0\u24a8\0\56\0\u24d6\0\56\0\u2504\0\u2532\0\56"+
    "\0\u2560\0\56\0\u258e\0\u25bc\0\56\0\u25ea\0\u2618\0\56"+
    "\0\u2646\0\u2674\0\56\0\56\0\u26a2\0\u26d0\0\56\0\56"+
    "\0\u26fe\0\u272c\0\56\0\56\0\u275a\0\56\0\u2788\0\u27b6"+
    "\0\56\0\u27e4\0\u2812\0\56\0\u2840\0\56";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[270];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\2\2\1\6\1\5\1\7"+
    "\1\5\1\10\1\11\2\5\1\12\1\5\3\4\1\13"+
    "\1\14\1\15\1\16\1\17\1\6\1\5\1\10\2\5"+
    "\1\4\1\11\1\20\1\21\1\12\1\7\1\5\1\22"+
    "\1\5\1\23\3\5\1\24\1\5\2\25\57\0\1\26"+
    "\1\27\15\0\1\30\1\31\35\0\1\32\1\0\2\5"+
    "\1\33\12\5\10\0\5\5\1\0\16\5\3\0\1\32"+
    "\1\0\2\5\1\33\1\5\1\34\10\5\10\0\1\5"+
    "\1\34\3\5\1\0\16\5\3\0\1\32\1\0\2\5"+
    "\1\33\1\5\1\35\10\5\10\0\1\5\1\35\3\5"+
    "\1\0\16\5\3\0\1\32\1\0\2\5\1\33\5\5"+
    "\1\36\4\5\10\0\4\5\1\37\1\0\1\36\15\5"+
    "\3\0\1\32\1\0\2\5\1\33\1\5\1\40\10\5"+
    "\10\0\1\5\1\40\3\5\1\0\16\5\3\0\1\32"+
    "\1\0\2\5\1\33\6\5\1\41\3\5\10\0\3\5"+
    "\1\41\1\5\1\0\16\5\11\0\1\42\1\43\2\0"+
    "\1\44\1\0\1\45\1\46\12\0\1\42\2\0\1\47"+
    "\1\50\1\44\2\0\1\46\1\43\1\0\1\51\1\45"+
    "\4\0\1\52\4\0\1\32\1\0\2\5\1\33\4\5"+
    "\1\53\5\5\10\0\2\5\1\53\2\5\1\0\16\5"+
    "\3\0\1\32\1\0\2\5\1\33\1\5\1\54\10\5"+
    "\10\0\1\5\1\54\3\5\1\0\16\5\3\0\1\32"+
    "\1\0\2\5\1\33\1\55\11\5\10\0\1\55\4\5"+
    "\1\0\16\5\3\0\1\32\1\0\2\5\1\33\4\5"+
    "\1\56\5\5\10\0\2\5\1\56\2\5\1\0\16\5"+
    "\3\0\1\32\1\0\2\5\1\33\1\5\1\57\10\5"+
    "\10\0\1\5\1\57\3\5\1\0\16\5\56\0\2\25"+
    "\1\0\1\60\1\27\15\0\1\30\1\31\35\0\1\27"+
    "\55\0\1\61\55\0\1\62\55\0\1\32\3\5\1\33"+
    "\12\5\10\0\5\5\1\0\16\5\10\0\1\63\50\0"+
    "\1\32\1\0\2\5\1\33\1\64\11\5\10\0\1\64"+
    "\4\5\1\0\16\5\3\0\1\32\1\0\2\5\1\33"+
    "\12\5\10\0\5\5\1\0\5\5\1\65\10\5\3\0"+
    "\1\32\1\0\2\5\1\33\4\5\1\66\5\5\10\0"+
    "\2\5\1\66\2\5\1\0\16\5\3\0\1\32\1\0"+
    "\2\5\1\33\2\5\1\67\7\5\10\0\5\5\1\0"+
    "\4\5\1\67\11\5\12\0\1\70\31\0\1\70\22\0"+
    "\1\71\21\0\1\71\33\0\1\72\21\0\1\72\32\0"+
    "\1\73\1\0\1\74\17\0\1\73\11\0\1\74\27\0"+
    "\1\75\16\0\1\75\12\0\1\76\23\0\1\77\16\0"+
    "\1\77\30\0\1\100\1\101\1\102\2\0\1\103\1\0"+
    "\1\104\1\105\11\0\1\100\1\101\2\0\1\106\1\0"+
    "\1\103\2\0\1\105\1\102\1\0\1\107\1\104\4\0"+
    "\1\110\11\0\1\111\21\0\1\111\34\0\1\112\21\0"+
    "\1\112\25\0\1\32\1\0\2\5\1\33\12\5\10\0"+
    "\5\5\1\0\2\5\1\113\13\5\3\0\1\32\1\0"+
    "\2\5\1\33\12\5\10\0\5\5\1\0\1\5\1\114"+
    "\14\5\3\0\1\32\1\0\2\5\1\33\12\5\10\0"+
    "\5\5\1\0\6\5\1\115\7\5\3\0\1\32\1\0"+
    "\2\5\1\33\1\116\11\5\10\0\1\116\4\5\1\0"+
    "\16\5\3\0\1\32\1\0\2\5\1\33\10\5\1\117"+
    "\1\5\10\0\5\5\1\0\3\5\1\117\12\5\3\0"+
    "\1\60\1\27\54\0\1\120\16\0\1\121\36\0\1\122"+
    "\17\0\1\123\43\0\1\124\47\0\1\32\1\0\2\5"+
    "\1\33\4\5\1\125\5\5\10\0\2\5\1\125\2\5"+
    "\1\0\16\5\3\0\1\32\1\0\2\5\1\33\4\5"+
    "\1\126\5\5\10\0\2\5\1\126\2\5\1\0\16\5"+
    "\3\0\1\32\1\0\2\5\1\33\10\5\1\127\1\5"+
    "\10\0\5\5\1\0\3\5\1\127\12\5\3\0\1\32"+
    "\1\0\2\5\1\33\2\5\1\130\7\5\10\0\5\5"+
    "\1\0\4\5\1\130\11\5\12\0\1\131\31\0\1\131"+
    "\56\0\1\132\36\0\1\133\75\0\1\134\27\0\1\135"+
    "\22\0\1\135\24\0\1\136\23\0\1\137\5\0\1\136"+
    "\30\0\1\140\27\0\1\140\27\0\1\141\30\0\1\141"+
    "\14\0\1\142\21\0\1\142\34\0\1\143\31\0\1\143"+
    "\22\0\1\144\21\0\1\144\33\0\1\145\21\0\1\145"+
    "\32\0\1\146\1\0\1\147\17\0\1\146\11\0\1\147"+
    "\27\0\1\150\16\0\1\150\12\0\1\151\23\0\1\152"+
    "\16\0\1\152\30\0\1\153\21\0\1\153\34\0\1\154"+
    "\21\0\1\154\70\0\1\155\27\0\1\156\22\0\1\156"+
    "\15\0\1\32\1\0\2\5\1\33\6\5\1\157\3\5"+
    "\10\0\3\5\1\157\1\5\1\0\16\5\3\0\1\32"+
    "\1\0\2\5\1\33\4\5\1\160\5\5\10\0\2\5"+
    "\1\160\2\5\1\0\16\5\3\0\1\32\1\0\2\5"+
    "\1\33\7\5\1\161\2\5\10\0\5\5\1\0\7\5"+
    "\1\161\6\5\3\0\1\32\1\0\2\5\1\33\12\5"+
    "\10\0\5\5\1\0\1\5\1\162\14\5\3\0\1\32"+
    "\1\0\2\5\1\33\12\5\10\0\5\5\1\0\15\5"+
    "\1\163\22\0\1\121\36\0\1\164\75\0\1\123\35\0"+
    "\1\165\64\0\1\166\46\0\1\32\1\0\2\5\1\33"+
    "\6\5\1\167\3\5\10\0\3\5\1\167\1\5\1\0"+
    "\16\5\3\0\1\32\1\0\2\5\1\33\1\170\11\5"+
    "\10\0\1\170\4\5\1\0\16\5\3\0\1\32\1\0"+
    "\2\5\1\33\4\5\1\171\5\5\10\0\2\5\1\171"+
    "\2\5\1\0\16\5\3\0\1\32\1\0\2\5\1\33"+
    "\1\5\1\172\10\5\10\0\1\5\1\172\3\5\1\0"+
    "\16\5\16\0\1\173\16\0\1\173\34\0\1\174\17\0"+
    "\1\174\57\0\1\175\74\0\1\176\12\0\1\177\31\0"+
    "\1\177\52\0\1\200\27\0\1\201\35\0\1\201\57\0"+
    "\1\202\12\0\1\203\21\0\1\203\35\0\1\204\31\0"+
    "\1\204\56\0\1\205\36\0\1\206\75\0\1\207\27\0"+
    "\1\210\22\0\1\210\24\0\1\211\23\0\1\212\5\0"+
    "\1\211\30\0\1\213\27\0\1\213\27\0\1\214\30\0"+
    "\1\214\51\0\1\215\27\0\1\216\22\0\1\216\31\0"+
    "\1\217\27\0\1\217\63\0\1\220\3\0\1\32\1\0"+
    "\2\5\1\33\10\5\1\221\1\5\10\0\5\5\1\0"+
    "\3\5\1\221\12\5\3\0\1\32\1\0\2\5\1\33"+
    "\2\5\1\222\7\5\10\0\5\5\1\0\4\5\1\222"+
    "\11\5\3\0\1\32\1\0\2\5\1\33\7\5\1\223"+
    "\2\5\10\0\5\5\1\0\7\5\1\223\6\5\3\0"+
    "\1\32\1\0\2\5\1\33\7\5\1\224\2\5\10\0"+
    "\5\5\1\0\7\5\1\224\6\5\3\0\1\225\55\0"+
    "\1\226\65\0\1\227\45\0\1\32\1\0\2\5\1\33"+
    "\12\5\10\0\4\5\1\230\1\0\16\5\3\0\1\32"+
    "\1\0\2\5\1\33\12\5\10\0\5\5\1\0\1\5"+
    "\1\231\14\5\3\0\1\32\1\0\2\5\1\33\6\5"+
    "\1\232\3\5\10\0\3\5\1\232\1\5\1\0\16\5"+
    "\3\0\1\32\1\0\2\5\1\33\6\5\1\233\3\5"+
    "\10\0\3\5\1\233\1\5\1\0\16\5\12\0\1\234"+
    "\31\0\1\234\21\0\1\235\21\0\1\235\64\0\1\236"+
    "\30\0\1\237\17\0\1\237\32\0\1\240\21\0\1\240"+
    "\33\0\1\241\21\0\1\241\33\0\1\242\21\0\1\242"+
    "\34\0\1\243\31\0\1\243\25\0\1\244\17\0\1\244"+
    "\37\0\1\245\16\0\1\245\34\0\1\246\17\0\1\246"+
    "\57\0\1\247\74\0\1\250\12\0\1\251\31\0\1\251"+
    "\52\0\1\252\27\0\1\253\35\0\1\253\57\0\1\254"+
    "\21\0\1\255\27\0\1\255\63\0\1\256\12\0\1\257"+
    "\31\0\1\257\30\0\1\260\27\0\1\260\11\0\1\32"+
    "\1\0\2\5\1\33\4\5\1\261\5\5\10\0\2\5"+
    "\1\261\2\5\1\0\16\5\3\0\1\32\1\0\2\5"+
    "\1\33\4\5\1\262\5\5\10\0\2\5\1\262\2\5"+
    "\1\0\16\5\3\0\1\32\1\0\2\5\1\33\12\5"+
    "\10\0\5\5\1\0\16\5\1\263\2\0\1\264\66\0"+
    "\1\265\44\0\1\32\1\0\2\5\1\33\2\5\1\266"+
    "\7\5\10\0\5\5\1\0\4\5\1\266\11\5\3\0"+
    "\1\32\1\0\2\5\1\33\1\267\11\5\10\0\1\267"+
    "\4\5\1\0\16\5\26\0\1\270\70\0\1\271\32\0"+
    "\1\272\16\0\1\272\33\0\1\273\35\0\1\273\22\0"+
    "\1\274\16\0\1\274\56\0\1\275\45\0\1\276\40\0"+
    "\1\277\21\0\1\277\40\0\1\300\16\0\1\300\32\0"+
    "\1\301\31\0\1\301\21\0\1\302\21\0\1\302\64\0"+
    "\1\303\30\0\1\304\17\0\1\304\32\0\1\305\21\0"+
    "\1\305\33\0\1\306\21\0\1\306\33\0\1\307\21\0"+
    "\1\307\34\0\1\310\31\0\1\310\23\0\1\311\31\0"+
    "\1\311\30\0\1\312\27\0\1\312\22\0\1\313\17\0"+
    "\1\313\47\0\1\314\32\0\1\32\1\0\2\5\1\33"+
    "\6\5\1\315\3\5\10\0\3\5\1\315\1\5\1\0"+
    "\16\5\3\0\1\32\1\0\2\5\1\33\6\5\1\316"+
    "\3\5\10\0\3\5\1\316\1\5\1\0\16\5\20\0"+
    "\1\317\22\0\1\317\15\0\1\320\67\0\1\321\43\0"+
    "\1\32\1\0\2\5\1\33\6\5\1\322\3\5\10\0"+
    "\3\5\1\322\1\5\1\0\16\5\12\0\1\323\31\0"+
    "\1\323\37\0\1\324\45\0\1\325\16\0\1\325\46\0"+
    "\1\326\43\0\1\327\17\0\1\327\47\0\1\330\65\0"+
    "\1\331\45\0\1\332\70\0\1\333\32\0\1\334\16\0"+
    "\1\334\33\0\1\335\35\0\1\335\22\0\1\336\16\0"+
    "\1\336\56\0\1\337\45\0\1\340\40\0\1\341\21\0"+
    "\1\341\36\0\1\342\17\0\1\342\47\0\1\343\45\0"+
    "\1\344\16\0\1\344\23\0\1\32\1\0\2\5\1\33"+
    "\12\5\10\0\4\5\1\345\1\0\16\5\16\0\1\346"+
    "\16\0\1\346\36\0\1\347\55\0\1\350\16\0\1\350"+
    "\46\0\1\351\44\0\1\352\22\0\1\352\43\0\1\353"+
    "\41\0\1\354\31\0\1\354\37\0\1\355\45\0\1\356"+
    "\16\0\1\356\30\0\1\357\15\0\1\360\3\0\1\357"+
    "\37\0\1\361\17\0\1\361\47\0\1\362\45\0\1\363"+
    "\16\0\1\363\30\0\1\364\15\0\1\365\3\0\1\364"+
    "\35\0\1\366\31\0\1\366\23\0\1\367\71\0\1\370"+
    "\45\0\1\371\16\0\1\371\36\0\1\372\16\0\1\372"+
    "\46\0\1\373\55\0\1\374\44\0\1\375\22\0\1\375"+
    "\25\0\1\376\15\0\1\377\3\0\1\376\51\0\1\u0100"+
    "\41\0\1\u0101\31\0\1\u0101\30\0\1\u0102\64\0\1\u0103"+
    "\55\0\1\u0104\45\0\1\u0105\16\0\1\u0105\46\0\1\u0106"+
    "\40\0\1\u0107\21\0\1\u0107\26\0\1\u0108\77\0\1\u0109"+
    "\45\0\1\u010a\16\0\1\u010a\40\0\1\u010b\45\0\1\u010c"+
    "\21\0\1\u010c\41\0\1\u010d\60\0\1\u010e\36\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[10350];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\7\1\4\11\10\1\2\0"+
    "\1\1\1\0\6\1\11\0\6\1\3\0\4\1\23\0"+
    "\5\1\5\0\4\1\2\0\1\11\23\0\5\1\1\0"+
    "\1\1\1\0\4\1\13\0\1\11\12\0\5\1\1\11"+
    "\1\0\4\1\25\0\2\1\3\0\2\1\1\11\5\0"+
    "\1\11\15\0\1\11\2\1\1\0\1\11\1\0\1\1"+
    "\1\0\1\11\1\0\1\11\1\0\1\11\1\0\1\11"+
    "\5\0\1\11\2\0\1\11\1\0\1\1\3\0\1\11"+
    "\1\0\1\11\1\0\1\11\2\0\1\11\1\0\1\11"+
    "\2\0\1\11\2\0\1\11\2\0\2\11\2\0\2\11"+
    "\2\0\2\11\1\0\1\11\2\0\1\11\2\0\1\11"+
    "\1\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[270];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
/* Lista con errores sintacticos */
public LinkedList<Errores> lista=new LinkedList<Errores>();
/* Metodo que es llamado al encontrar un error lexico */
private void ErrorScan(int linea, int columna, String valor){
lista.add(new Errores(linea, columna, "Error lexico en el caracter "+valor) );}


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public scanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 160) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 32: 
          { return new Symbol(simbolo.clave2, yychar,yyline,new String(yytext()));
          }
        case 52: break;
        case 28: 
          { return new Symbol(simbolo.asunto1, yychar,yyline,new String(yytext()));
          }
        case 53: break;
        case 33: 
          { return new Symbol(simbolo.fecha2, yychar,yyline,new String(yytext()));
          }
        case 54: break;
        case 49: 
          { return new Symbol(simbolo.contenido2, yychar,yyline,new String(yytext()));
          }
        case 55: break;
        case 43: 
          { return new Symbol(simbolo.correos2, yychar,yyline,new String(yytext()));
          }
        case 56: break;
        case 20: 
          { return new Symbol(simbolo.inicio, yychar,yyline,new String(yytext()));
          }
        case 57: break;
        case 29: 
          { return new Symbol(simbolo.correo1, yychar,yyline,new String(yytext()));
          }
        case 58: break;
        case 41: 
          { return new Symbol(simbolo.registro1, yychar,yyline,new String(yytext()));
          }
        case 59: break;
        case 42: 
          { return new Symbol(simbolo.archivo2, yychar,yyline,new String(yytext()));
          }
        case 60: break;
        case 39: 
          { return new Symbol(simbolo.nombre2, yychar,yyline,new String(yytext()));
          }
        case 61: break;
        case 36: 
          { return new Symbol(simbolo.sesion2, yychar,yyline,new String(yytext()));
          }
        case 62: break;
        case 23: 
          { return new Symbol(simbolo.error1, yychar,yyline,new String(yytext()));
          }
        case 63: break;
        case 18: 
          { return new Symbol(simbolo.fecha, yychar,yyline,new String(yytext()));
          }
        case 64: break;
        case 24: 
          { return new Symbol(simbolo.clave1, yychar,yyline,new String(yytext()));
          }
        case 65: break;
        case 48: 
          { return new Symbol(simbolo.usuarios2, yychar,yyline,new String(yytext()));
          }
        case 66: break;
        case 25: 
          { return new Symbol(simbolo.fecha1, yychar,yyline,new String(yytext()));
          }
        case 67: break;
        case 22: 
          { return new Symbol(simbolo.correos1, yychar,yyline,new String(yytext()));
          }
        case 68: break;
        case 1: 
          { ErrorScan(yyline,yychar,yytext());
          }
        case 69: break;
        case 46: 
          { return new Symbol(simbolo.contenido1, yychar,yyline,new String(yytext()));
          }
        case 70: break;
        case 8: 
          { return new Symbol(simbolo.igual, yychar,yyline,new String(yytext()));
          }
        case 71: break;
        case 9: 
          { return new Symbol(simbolo.coma, yychar,yyline,new String(yytext()));
          }
        case 72: break;
        case 35: 
          { return new Symbol(simbolo.archivo1, yychar,yyline,new String(yytext()));
          }
        case 73: break;
        case 19: 
          { return new Symbol(simbolo.sesion1, yychar,yyline,new String(yytext()));
          }
        case 74: break;
        case 4: 
          { return new Symbol(simbolo.cad, yychar,yyline,new String(yytext()));
          }
        case 75: break;
        case 30: 
          { return new Symbol(simbolo.nombre1, yychar,yyline,new String(yytext()));
          }
        case 76: break;
        case 15: 
          { return new Symbol(simbolo.hora, yychar,yyline,new String(yytext()));
          }
        case 77: break;
        case 34: 
          { return new Symbol(simbolo.peticion, yychar,yyline,new String(yytext()));
          }
        case 78: break;
        case 6: 
          { return new Symbol(simbolo.cerrar, yychar,yyline,new String(yytext()));
          }
        case 79: break;
        case 44: 
          { return new Symbol(simbolo.usuario2, yychar,yyline,new String(yytext()));
          }
        case 80: break;
        case 45: 
          { return new Symbol(simbolo.usuarios1, yychar,yyline,new String(yytext()));
          }
        case 81: break;
        case 26: 
          { return new Symbol(simbolo.usuario, yychar,yyline,new String(yytext()));
          }
        case 82: break;
        case 27: 
          { return new Symbol(simbolo.registro, yychar,yyline,new String(yytext()));
          }
        case 83: break;
        case 12: 
          { return new Symbol(simbolo.de, yychar,yyline,new String(yytext()));
          }
        case 84: break;
        case 14: 
          { return new Symbol(simbolo.tipo, yychar,yyline,new String(yytext()));
          }
        case 85: break;
        case 5: 
          { return new Symbol(simbolo.abrir, yychar,yyline,new String(yytext()));
          }
        case 86: break;
        case 7: 
          { return new Symbol(simbolo.c2, yychar,yyline,new String(yytext()));
          }
        case 87: break;
        case 16: 
          { return new Symbol(simbolo.de2, yychar,yyline,new String(yytext()));
          }
        case 88: break;
        case 40: 
          { return new Symbol(simbolo.usuario1, yychar,yyline,new String(yytext()));
          }
        case 89: break;
        case 3: 
          { return new Symbol(simbolo.signos, yychar,yyline,new String(yytext()));
          }
        case 90: break;
        case 50: 
          { return new Symbol(simbolo.listaC, yychar,yyline,new String(yytext()));
          }
        case 91: break;
        case 37: 
          { return new Symbol(simbolo.asunto2, yychar,yyline,new String(yytext()));
          }
        case 92: break;
        case 2: 
          { return new Symbol(simbolo.num, yychar,yyline,new String(yytext()));
          }
        case 93: break;
        case 11: 
          { return new Symbol(simbolo.id, yychar,yyline,new String(yytext()));
          }
        case 94: break;
        case 10: 
          { /* Se ignoran */
          }
        case 95: break;
        case 38: 
          { return new Symbol(simbolo.correo2, yychar,yyline,new String(yytext()));
          }
        case 96: break;
        case 21: 
          { return new Symbol(simbolo.correo_t, yychar,yyline,new String(yytext()));
          }
        case 97: break;
        case 47: 
          { return new Symbol(simbolo.registro2, yychar,yyline,new String(yytext()));
          }
        case 98: break;
        case 17: 
          { return new Symbol(simbolo.fecha_t, yychar,yyline,new String(yytext()));
          }
        case 99: break;
        case 51: 
          { return new Symbol(simbolo.correo, yychar,yyline,new String(yytext()));
          }
        case 100: break;
        case 13: 
          { return new Symbol(simbolo.de1, yychar,yyline,new String(yytext()));
          }
        case 101: break;
        case 31: 
          { return new Symbol(simbolo.error2, yychar,yyline,new String(yytext()));
          }
        case 102: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(simbolo.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
