// Generated from edu\stanford\futuredata\macrobase\SqlBase.g4 by ANTLR 4.7
package edu.stanford.futuredata.macrobase;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlBaseParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, ADD=5, ALL=6, ALTER=7, ANALYZE=8, AND=9, 
		ANY=10, ARRAY=11, AS=12, ASC=13, AT=14, BERNOULLI=15, BETWEEN=16, BY=17, 
		CALL=18, CASCADE=19, CASE=20, CAST=21, CATALOGS=22, COALESCE=23, COLUMN=24, 
		COLUMNS=25, COMBO=26, COMMENT=27, COMMIT=28, COMMITTED=29, COMPARE=30, 
		CONSTRAINT=31, COUNT=32, CREATE=33, CSV=34, CROSS=35, CUBE=36, CURRENT=37, 
		DATA=38, DATE=39, DAY=40, DEALLOCATE=41, DELETE=42, DESC=43, DESCRIBE=44, 
		DIFF=45, DISTINCT=46, DISTRIBUTED=47, DROP=48, ELSE=49, ENCLOSED=50, END=51, 
		ESCAPE=52, ESCAPED=53, EXCEPT=54, EXCLUDING=55, EXECUTE=56, EXISTS=57, 
		EXPLAIN=58, EXTRACT=59, FALSE=60, FIELDS=61, FILE=62, FILTER=63, FIRST=64, 
		FOLLOWING=65, FOR=66, FORMAT=67, FROM=68, FULL=69, FUNCTIONS=70, GRANT=71, 
		GRANTS=72, GRAPHVIZ=73, GROUP=74, GROUPING=75, HAVING=76, HOUR=77, IF=78, 
		IMPORT=79, IN=80, INCLUDING=81, INNER=82, INPUT=83, INSERT=84, INTEGER=85, 
		INTERSECT=86, INTERVAL=87, INTO=88, IS=89, ISOLATION=90, JOIN=91, LAST=92, 
		LATERAL=93, LEFT=94, LEVEL=95, LIKE=96, LIMIT=97, LINES=98, LOGICAL=99, 
		MAP=100, MAX=101, MIN=102, MIN_SUPPORT=103, MINUTE=104, MONTH=105, NATURAL=106, 
		NFC=107, NFD=108, NFKC=109, NFKD=110, NO=111, NOT=112, NULL=113, NULLIF=114, 
		NULLS=115, ON=116, ONLY=117, OPTION=118, OPTIONALLY=119, OR=120, ORDER=121, 
		ORDINALITY=122, OUTER=123, OUTFILE=124, OUTPUT=125, OVER=126, PARTITION=127, 
		PARTITIONS=128, POSITION=129, PRECEDING=130, PREPARE=131, PRIVILEGES=132, 
		PROPERTIES=133, PUBLIC=134, RANGE=135, RATIO=136, READ=137, RECURSIVE=138, 
		RENAME=139, REPEATABLE=140, REPLACE=141, RESET=142, RESTRICT=143, REVOKE=144, 
		RIGHT=145, ROLLBACK=146, ROLLUP=147, ROW=148, ROWS=149, SCHEMA=150, SCHEMAS=151, 
		SECOND=152, SELECT=153, SESSION=154, SET=155, SETS=156, SHOW=157, SMALLINT=158, 
		SOME=159, SPLIT=160, START=161, STARTING=162, STATS=163, SUBSTRING=164, 
		SUM=165, SYSTEM=166, TABLE=167, TABLES=168, TABLESAMPLE=169, TERMINATED=170, 
		TEXT=171, THEN=172, TIME=173, TIMESTAMP=174, TINYINT=175, TO=176, TRUE=177, 
		TRY_CAST=178, TYPE=179, UESCAPE=180, UNBOUNDED=181, UNCOMMITTED=182, UNION=183, 
		UNNEST=184, USE=185, USING=186, VALIDATE=187, VALUES=188, VERBOSE=189, 
		VIEW=190, WHEN=191, WHERE=192, WITH=193, WORK=194, WRITE=195, YEAR=196, 
		ZONE=197, EQ=198, NEQ=199, LT=200, LTE=201, GT=202, GTE=203, PLUS=204, 
		MINUS=205, ASTERISK=206, SLASH=207, PERCENT=208, CONCAT=209, STRING=210, 
		UNICODE_STRING=211, BINARY_LITERAL=212, INTEGER_VALUE=213, DECIMAL_VALUE=214, 
		IDENTIFIER=215, DIGIT_IDENTIFIER=216, QUOTED_IDENTIFIER=217, BACKQUOTED_IDENTIFIER=218, 
		TIME_WITH_TIME_ZONE=219, TIMESTAMP_WITH_TIME_ZONE=220, DOUBLE_PRECISION=221, 
		SIMPLE_COMMENT=222, BRACKETED_COMMENT=223, WS=224, UNRECOGNIZED=225, DELIMITER=226;
	public static final int
		RULE_singleStatement = 0, RULE_singleExpression = 1, RULE_statement = 2, 
		RULE_query = 3, RULE_queryTerm = 4, RULE_queryPrimary = 5, RULE_querySpecification = 6, 
		RULE_diffQuerySpecification = 7, RULE_splitQuery = 8, RULE_columnDefinition = 9, 
		RULE_sortItem = 10, RULE_minRatioExpression = 11, RULE_minSupportExpression = 12, 
		RULE_ratioMetricExpression = 13, RULE_aggregateExpression = 14, RULE_aggregate = 15, 
		RULE_setQuantifier = 16, RULE_selectItem = 17, RULE_exportClause = 18, 
		RULE_delimiterClause = 19, RULE_escapeClause = 20, RULE_relation = 21, 
		RULE_joinType = 22, RULE_joinCriteria = 23, RULE_aliasedRelation = 24, 
		RULE_columnAliases = 25, RULE_relationPrimary = 26, RULE_expression = 27, 
		RULE_booleanExpression = 28, RULE_predicated = 29, RULE_predicate = 30, 
		RULE_valueExpression = 31, RULE_primaryExpression = 32, RULE_string = 33, 
		RULE_comparisonOperator = 34, RULE_comparisonQuantifier = 35, RULE_booleanValue = 36, 
		RULE_type = 37, RULE_typeParameter = 38, RULE_baseType = 39, RULE_whenClause = 40, 
		RULE_filter = 41, RULE_qualifiedName = 42, RULE_identifier = 43, RULE_number = 44, 
		RULE_nonReserved = 45;
	public static final String[] ruleNames = {
		"singleStatement", "singleExpression", "statement", "query", "queryTerm", 
		"queryPrimary", "querySpecification", "diffQuerySpecification", "splitQuery", 
		"columnDefinition", "sortItem", "minRatioExpression", "minSupportExpression", 
		"ratioMetricExpression", "aggregateExpression", "aggregate", "setQuantifier", 
		"selectItem", "exportClause", "delimiterClause", "escapeClause", "relation", 
		"joinType", "joinCriteria", "aliasedRelation", "columnAliases", "relationPrimary", 
		"expression", "booleanExpression", "predicated", "predicate", "valueExpression", 
		"primaryExpression", "string", "comparisonOperator", "comparisonQuantifier", 
		"booleanValue", "type", "typeParameter", "baseType", "whenClause", "filter", 
		"qualifiedName", "identifier", "number", "nonReserved"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "'.'", "'ADD'", "'ALL'", "'ALTER'", "'ANALYZE'", 
		"'AND'", "'ANY'", "'ARRAY'", "'AS'", "'ASC'", "'AT'", "'BERNOULLI'", "'BETWEEN'", 
		"'BY'", "'CALL'", "'CASCADE'", "'CASE'", "'CAST'", "'CATALOGS'", "'COALESCE'", 
		"'COLUMN'", "'COLUMNS'", "'COMBO'", "'COMMENT'", "'COMMIT'", "'COMMITTED'", 
		"'COMPARE'", "'CONSTRAINT'", "'COUNT'", "'CREATE'", "'CSV'", "'CROSS'", 
		"'CUBE'", "'CURRENT'", "'DATA'", "'DATE'", "'DAY'", "'DEALLOCATE'", "'DELETE'", 
		"'DESC'", "'DESCRIBE'", "'DIFF'", "'DISTINCT'", "'DISTRIBUTED'", "'DROP'", 
		"'ELSE'", "'ENCLOSED'", "'END'", "'ESCAPE'", "'ESCAPED'", "'EXCEPT'", 
		"'EXCLUDING'", "'EXECUTE'", "'EXISTS'", "'EXPLAIN'", "'EXTRACT'", "'FALSE'", 
		"'FIELDS'", "'FILE'", "'FILTER'", "'FIRST'", "'FOLLOWING'", "'FOR'", "'FORMAT'", 
		"'FROM'", "'FULL'", "'FUNCTIONS'", "'GRANT'", "'GRANTS'", "'GRAPHVIZ'", 
		"'GROUP'", "'GROUPING'", "'HAVING'", "'HOUR'", "'IF'", "'IMPORT'", "'IN'", 
		"'INCLUDING'", "'INNER'", "'INPUT'", "'INSERT'", "'INTEGER'", "'INTERSECT'", 
		"'INTERVAL'", "'INTO'", "'IS'", "'ISOLATION'", "'JOIN'", "'LAST'", "'LATERAL'", 
		"'LEFT'", "'LEVEL'", "'LIKE'", "'LIMIT'", "'LINES'", "'LOGICAL'", "'MAP'", 
		"'MAX'", "'MIN'", "'MIN SUPPORT'", "'MINUTE'", "'MONTH'", "'NATURAL'", 
		"'NFC'", "'NFD'", "'NFKC'", "'NFKD'", "'NO'", "'NOT'", "'NULL'", "'NULLIF'", 
		"'NULLS'", "'ON'", "'ONLY'", "'OPTION'", "'OPTIONALLY'", "'OR'", "'ORDER'", 
		"'ORDINALITY'", "'OUTER'", "'OUTFILE'", "'OUTPUT'", "'OVER'", "'PARTITION'", 
		"'PARTITIONS'", "'POSITION'", "'PRECEDING'", "'PREPARE'", "'PRIVILEGES'", 
		"'PROPERTIES'", "'PUBLIC'", "'RANGE'", "'RATIO'", "'READ'", "'RECURSIVE'", 
		"'RENAME'", "'REPEATABLE'", "'REPLACE'", "'RESET'", "'RESTRICT'", "'REVOKE'", 
		"'RIGHT'", "'ROLLBACK'", "'ROLLUP'", "'ROW'", "'ROWS'", "'SCHEMA'", "'SCHEMAS'", 
		"'SECOND'", "'SELECT'", "'SESSION'", "'SET'", "'SETS'", "'SHOW'", "'SMALLINT'", 
		"'SOME'", "'SPLIT'", "'START'", "'STARTING'", "'STATS'", "'SUBSTRING'", 
		"'SUM'", "'SYSTEM'", "'TABLE'", "'TABLES'", "'TABLESAMPLE'", "'TERMINATED'", 
		"'TEXT'", "'THEN'", "'TIME'", "'TIMESTAMP'", "'TINYINT'", "'TO'", "'TRUE'", 
		"'TRY_CAST'", "'TYPE'", "'UESCAPE'", "'UNBOUNDED'", "'UNCOMMITTED'", "'UNION'", 
		"'UNNEST'", "'USE'", "'USING'", "'VALIDATE'", "'VALUES'", "'VERBOSE'", 
		"'VIEW'", "'WHEN'", "'WHERE'", "'WITH'", "'WORK'", "'WRITE'", "'YEAR'", 
		"'ZONE'", "'='", null, "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", 
		"'/'", "'%'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "ADD", "ALL", "ALTER", "ANALYZE", "AND", 
		"ANY", "ARRAY", "AS", "ASC", "AT", "BERNOULLI", "BETWEEN", "BY", "CALL", 
		"CASCADE", "CASE", "CAST", "CATALOGS", "COALESCE", "COLUMN", "COLUMNS", 
		"COMBO", "COMMENT", "COMMIT", "COMMITTED", "COMPARE", "CONSTRAINT", "COUNT", 
		"CREATE", "CSV", "CROSS", "CUBE", "CURRENT", "DATA", "DATE", "DAY", "DEALLOCATE", 
		"DELETE", "DESC", "DESCRIBE", "DIFF", "DISTINCT", "DISTRIBUTED", "DROP", 
		"ELSE", "ENCLOSED", "END", "ESCAPE", "ESCAPED", "EXCEPT", "EXCLUDING", 
		"EXECUTE", "EXISTS", "EXPLAIN", "EXTRACT", "FALSE", "FIELDS", "FILE", 
		"FILTER", "FIRST", "FOLLOWING", "FOR", "FORMAT", "FROM", "FULL", "FUNCTIONS", 
		"GRANT", "GRANTS", "GRAPHVIZ", "GROUP", "GROUPING", "HAVING", "HOUR", 
		"IF", "IMPORT", "IN", "INCLUDING", "INNER", "INPUT", "INSERT", "INTEGER", 
		"INTERSECT", "INTERVAL", "INTO", "IS", "ISOLATION", "JOIN", "LAST", "LATERAL", 
		"LEFT", "LEVEL", "LIKE", "LIMIT", "LINES", "LOGICAL", "MAP", "MAX", "MIN", 
		"MIN_SUPPORT", "MINUTE", "MONTH", "NATURAL", "NFC", "NFD", "NFKC", "NFKD", 
		"NO", "NOT", "NULL", "NULLIF", "NULLS", "ON", "ONLY", "OPTION", "OPTIONALLY", 
		"OR", "ORDER", "ORDINALITY", "OUTER", "OUTFILE", "OUTPUT", "OVER", "PARTITION", 
		"PARTITIONS", "POSITION", "PRECEDING", "PREPARE", "PRIVILEGES", "PROPERTIES", 
		"PUBLIC", "RANGE", "RATIO", "READ", "RECURSIVE", "RENAME", "REPEATABLE", 
		"REPLACE", "RESET", "RESTRICT", "REVOKE", "RIGHT", "ROLLBACK", "ROLLUP", 
		"ROW", "ROWS", "SCHEMA", "SCHEMAS", "SECOND", "SELECT", "SESSION", "SET", 
		"SETS", "SHOW", "SMALLINT", "SOME", "SPLIT", "START", "STARTING", "STATS", 
		"SUBSTRING", "SUM", "SYSTEM", "TABLE", "TABLES", "TABLESAMPLE", "TERMINATED", 
		"TEXT", "THEN", "TIME", "TIMESTAMP", "TINYINT", "TO", "TRUE", "TRY_CAST", 
		"TYPE", "UESCAPE", "UNBOUNDED", "UNCOMMITTED", "UNION", "UNNEST", "USE", 
		"USING", "VALIDATE", "VALUES", "VERBOSE", "VIEW", "WHEN", "WHERE", "WITH", 
		"WORK", "WRITE", "YEAR", "ZONE", "EQ", "NEQ", "LT", "LTE", "GT", "GTE", 
		"PLUS", "MINUS", "ASTERISK", "SLASH", "PERCENT", "CONCAT", "STRING", "UNICODE_STRING", 
		"BINARY_LITERAL", "INTEGER_VALUE", "DECIMAL_VALUE", "IDENTIFIER", "DIGIT_IDENTIFIER", 
		"QUOTED_IDENTIFIER", "BACKQUOTED_IDENTIFIER", "TIME_WITH_TIME_ZONE", "TIMESTAMP_WITH_TIME_ZONE", 
		"DOUBLE_PRECISION", "SIMPLE_COMMENT", "BRACKETED_COMMENT", "WS", "UNRECOGNIZED", 
		"DELIMITER"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SqlBase.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SqlBaseParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SingleStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlBaseParser.EOF, 0); }
		public SingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementContext singleStatement() throws RecognitionException {
		SingleStatementContext _localctx = new SingleStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_singleStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			statement();
			setState(93);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SqlBaseParser.EOF, 0); }
		public SingleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSingleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSingleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSingleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleExpressionContext singleExpression() throws RecognitionException {
		SingleExpressionContext _localctx = new SingleExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_singleExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			expression();
			setState(96);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ImportCsvContext extends StatementContext {
		public TerminalNode IMPORT() { return getToken(SqlBaseParser.IMPORT, 0); }
		public TerminalNode FROM() { return getToken(SqlBaseParser.FROM, 0); }
		public TerminalNode CSV() { return getToken(SqlBaseParser.CSV, 0); }
		public TerminalNode FILE() { return getToken(SqlBaseParser.FILE, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public TerminalNode INTO() { return getToken(SqlBaseParser.INTO, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public List<ColumnDefinitionContext> columnDefinition() {
			return getRuleContexts(ColumnDefinitionContext.class);
		}
		public ColumnDefinitionContext columnDefinition(int i) {
			return getRuleContext(ColumnDefinitionContext.class,i);
		}
		public ImportCsvContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterImportCsv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitImportCsv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitImportCsv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementDefaultContext extends StatementContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public StatementDefaultContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterStatementDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitStatementDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitStatementDefault(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case SELECT:
			case TABLE:
				_localctx = new StatementDefaultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				query();
				}
				break;
			case IMPORT:
				_localctx = new ImportCsvContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(IMPORT);
				setState(100);
				match(FROM);
				setState(101);
				match(CSV);
				setState(102);
				match(FILE);
				setState(103);
				match(STRING);
				setState(104);
				match(INTO);
				setState(105);
				qualifiedName();
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(106);
					match(T__0);
					setState(107);
					columnDefinition();
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(108);
						match(T__1);
						setState(109);
						columnDefinition();
						}
						}
						setState(114);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(115);
					match(T__2);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryContext extends ParserRuleContext {
		public QueryTermContext queryTerm() {
			return getRuleContext(QueryTermContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			queryTerm();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryTermContext extends ParserRuleContext {
		public QueryTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryTerm; }
	 
		public QueryTermContext() { }
		public void copyFrom(QueryTermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QueryTermDefaultContext extends QueryTermContext {
		public QueryPrimaryContext queryPrimary() {
			return getRuleContext(QueryPrimaryContext.class,0);
		}
		public QueryTermDefaultContext(QueryTermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterQueryTermDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitQueryTermDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitQueryTermDefault(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryTermContext queryTerm() throws RecognitionException {
		QueryTermContext _localctx = new QueryTermContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_queryTerm);
		try {
			_localctx = new QueryTermDefaultContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			queryPrimary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryPrimaryContext extends ParserRuleContext {
		public QueryPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryPrimary; }
	 
		public QueryPrimaryContext() { }
		public void copyFrom(QueryPrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubqueryContext extends QueryPrimaryContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public SubqueryContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSubquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSubquery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSubquery(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QueryPrimaryDefaultContext extends QueryPrimaryContext {
		public QuerySpecificationContext querySpecification() {
			return getRuleContext(QuerySpecificationContext.class,0);
		}
		public QueryPrimaryDefaultContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterQueryPrimaryDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitQueryPrimaryDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitQueryPrimaryDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TableContext extends QueryPrimaryContext {
		public TerminalNode TABLE() { return getToken(SqlBaseParser.TABLE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TableContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DiffQueryContext extends QueryPrimaryContext {
		public DiffQuerySpecificationContext diffQuerySpecification() {
			return getRuleContext(DiffQuerySpecificationContext.class,0);
		}
		public DiffQueryContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterDiffQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitDiffQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitDiffQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryPrimaryContext queryPrimary() throws RecognitionException {
		QueryPrimaryContext _localctx = new QueryPrimaryContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_queryPrimary);
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new QueryPrimaryDefaultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				querySpecification();
				}
				break;
			case 2:
				_localctx = new DiffQueryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				diffQuerySpecification();
				}
				break;
			case 3:
				_localctx = new TableContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				match(TABLE);
				setState(128);
				qualifiedName();
				}
				break;
			case 4:
				_localctx = new SubqueryContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(129);
				match(T__0);
				setState(130);
				query();
				setState(131);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuerySpecificationContext extends ParserRuleContext {
		public BooleanExpressionContext where;
		public Token limit;
		public TerminalNode SELECT() { return getToken(SqlBaseParser.SELECT, 0); }
		public List<SelectItemContext> selectItem() {
			return getRuleContexts(SelectItemContext.class);
		}
		public SelectItemContext selectItem(int i) {
			return getRuleContext(SelectItemContext.class,i);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SqlBaseParser.FROM, 0); }
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public TerminalNode WHERE() { return getToken(SqlBaseParser.WHERE, 0); }
		public TerminalNode ORDER() { return getToken(SqlBaseParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(SqlBaseParser.BY, 0); }
		public List<SortItemContext> sortItem() {
			return getRuleContexts(SortItemContext.class);
		}
		public SortItemContext sortItem(int i) {
			return getRuleContext(SortItemContext.class,i);
		}
		public TerminalNode LIMIT() { return getToken(SqlBaseParser.LIMIT, 0); }
		public ExportClauseContext exportClause() {
			return getRuleContext(ExportClauseContext.class,0);
		}
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public TerminalNode INTEGER_VALUE() { return getToken(SqlBaseParser.INTEGER_VALUE, 0); }
		public TerminalNode ALL() { return getToken(SqlBaseParser.ALL, 0); }
		public QuerySpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_querySpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterQuerySpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitQuerySpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitQuerySpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuerySpecificationContext querySpecification() throws RecognitionException {
		QuerySpecificationContext _localctx = new QuerySpecificationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_querySpecification);
		int _la;
		try {
			int _alt;
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				match(SELECT);
				setState(137);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(136);
					setQuantifier();
					}
					break;
				}
				setState(139);
				selectItem();
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(140);
						match(T__1);
						setState(141);
						selectItem();
						}
						} 
					}
					setState(146);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FROM) {
					{
					setState(147);
					match(FROM);
					setState(148);
					relation();
					setState(153);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(149);
							match(T__1);
							setState(150);
							relation();
							}
							} 
						}
						setState(155);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
					}
					}
				}

				setState(160);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(158);
					match(WHERE);
					setState(159);
					((QuerySpecificationContext)_localctx).where = booleanExpression(0);
					}
					break;
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER) {
					{
					setState(162);
					match(ORDER);
					setState(163);
					match(BY);
					setState(164);
					sortItem();
					setState(169);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(165);
							match(T__1);
							setState(166);
							sortItem();
							}
							} 
						}
						setState(171);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
					}
					}
				}

				setState(176);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(174);
					match(LIMIT);
					setState(175);
					((QuerySpecificationContext)_localctx).limit = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==INTEGER_VALUE) ) {
						((QuerySpecificationContext)_localctx).limit = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTO) {
					{
					setState(178);
					exportClause();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				match(SELECT);
				setState(183);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(182);
					setQuantifier();
					}
					break;
				}
				setState(185);
				selectItem();
				setState(190);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(186);
						match(T__1);
						setState(187);
						selectItem();
						}
						} 
					}
					setState(192);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTO) {
					{
					setState(193);
					exportClause();
					}
				}

				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FROM) {
					{
					setState(196);
					match(FROM);
					setState(197);
					relation();
					setState(202);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(198);
							match(T__1);
							setState(199);
							relation();
							}
							} 
						}
						setState(204);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
					}
					}
				}

				setState(209);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(207);
					match(WHERE);
					setState(208);
					((QuerySpecificationContext)_localctx).where = booleanExpression(0);
					}
					break;
				}
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER) {
					{
					setState(211);
					match(ORDER);
					setState(212);
					match(BY);
					setState(213);
					sortItem();
					setState(218);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(214);
							match(T__1);
							setState(215);
							sortItem();
							}
							} 
						}
						setState(220);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
					}
					}
				}

				setState(225);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(223);
					match(LIMIT);
					setState(224);
					((QuerySpecificationContext)_localctx).limit = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==INTEGER_VALUE) ) {
						((QuerySpecificationContext)_localctx).limit = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DiffQuerySpecificationContext extends ParserRuleContext {
		public Token maxCombo;
		public BooleanExpressionContext where;
		public Token limit;
		public TerminalNode SELECT() { return getToken(SqlBaseParser.SELECT, 0); }
		public List<SelectItemContext> selectItem() {
			return getRuleContexts(SelectItemContext.class);
		}
		public SelectItemContext selectItem(int i) {
			return getRuleContext(SelectItemContext.class,i);
		}
		public TerminalNode FROM() { return getToken(SqlBaseParser.FROM, 0); }
		public TerminalNode DIFF() { return getToken(SqlBaseParser.DIFF, 0); }
		public List<QueryTermContext> queryTerm() {
			return getRuleContexts(QueryTermContext.class);
		}
		public QueryTermContext queryTerm(int i) {
			return getRuleContext(QueryTermContext.class,i);
		}
		public TerminalNode ON() { return getToken(SqlBaseParser.ON, 0); }
		public ColumnAliasesContext columnAliases() {
			return getRuleContext(ColumnAliasesContext.class,0);
		}
		public TerminalNode ASTERISK() { return getToken(SqlBaseParser.ASTERISK, 0); }
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public TerminalNode WITH() { return getToken(SqlBaseParser.WITH, 0); }
		public TerminalNode COMPARE() { return getToken(SqlBaseParser.COMPARE, 0); }
		public List<TerminalNode> BY() { return getTokens(SqlBaseParser.BY); }
		public TerminalNode BY(int i) {
			return getToken(SqlBaseParser.BY, i);
		}
		public RatioMetricExpressionContext ratioMetricExpression() {
			return getRuleContext(RatioMetricExpressionContext.class,0);
		}
		public TerminalNode MAX() { return getToken(SqlBaseParser.MAX, 0); }
		public TerminalNode COMBO() { return getToken(SqlBaseParser.COMBO, 0); }
		public TerminalNode WHERE() { return getToken(SqlBaseParser.WHERE, 0); }
		public TerminalNode ORDER() { return getToken(SqlBaseParser.ORDER, 0); }
		public List<SortItemContext> sortItem() {
			return getRuleContexts(SortItemContext.class);
		}
		public SortItemContext sortItem(int i) {
			return getRuleContext(SortItemContext.class,i);
		}
		public TerminalNode LIMIT() { return getToken(SqlBaseParser.LIMIT, 0); }
		public ExportClauseContext exportClause() {
			return getRuleContext(ExportClauseContext.class,0);
		}
		public List<TerminalNode> INTEGER_VALUE() { return getTokens(SqlBaseParser.INTEGER_VALUE); }
		public TerminalNode INTEGER_VALUE(int i) {
			return getToken(SqlBaseParser.INTEGER_VALUE, i);
		}
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public TerminalNode ALL() { return getToken(SqlBaseParser.ALL, 0); }
		public MinRatioExpressionContext minRatioExpression() {
			return getRuleContext(MinRatioExpressionContext.class,0);
		}
		public MinSupportExpressionContext minSupportExpression() {
			return getRuleContext(MinSupportExpressionContext.class,0);
		}
		public SplitQueryContext splitQuery() {
			return getRuleContext(SplitQueryContext.class,0);
		}
		public DiffQuerySpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_diffQuerySpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterDiffQuerySpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitDiffQuerySpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitDiffQuerySpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DiffQuerySpecificationContext diffQuerySpecification() throws RecognitionException {
		DiffQuerySpecificationContext _localctx = new DiffQuerySpecificationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_diffQuerySpecification);
		int _la;
		try {
			int _alt;
			setState(529);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				match(SELECT);
				setState(231);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(230);
					setQuantifier();
					}
					break;
				}
				setState(233);
				selectItem();
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(234);
					match(T__1);
					setState(235);
					selectItem();
					}
					}
					setState(240);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(241);
				match(FROM);
				setState(242);
				match(DIFF);
				setState(243);
				queryTerm();
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << ALL) | (1L << ANALYZE) | (1L << ANY) | (1L << ARRAY) | (1L << ASC) | (1L << AT) | (1L << BERNOULLI) | (1L << CALL) | (1L << CASCADE) | (1L << CATALOGS) | (1L << COALESCE) | (1L << COLUMN) | (1L << COLUMNS) | (1L << COMMENT) | (1L << COMMIT) | (1L << COMMITTED) | (1L << CURRENT) | (1L << DATA) | (1L << DATE) | (1L << DAY) | (1L << DESC) | (1L << DISTRIBUTED) | (1L << EXCLUDING) | (1L << EXPLAIN) | (1L << FILTER))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FIRST - 64)) | (1L << (FOLLOWING - 64)) | (1L << (FORMAT - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (GRANT - 64)) | (1L << (GRANTS - 64)) | (1L << (GRAPHVIZ - 64)) | (1L << (HOUR - 64)) | (1L << (IF - 64)) | (1L << (INCLUDING - 64)) | (1L << (INPUT - 64)) | (1L << (INTEGER - 64)) | (1L << (INTERVAL - 64)) | (1L << (ISOLATION - 64)) | (1L << (LAST - 64)) | (1L << (LATERAL - 64)) | (1L << (LEVEL - 64)) | (1L << (LIMIT - 64)) | (1L << (LOGICAL - 64)) | (1L << (MAP - 64)) | (1L << (MINUTE - 64)) | (1L << (MONTH - 64)) | (1L << (NFC - 64)) | (1L << (NFD - 64)) | (1L << (NFKC - 64)) | (1L << (NFKD - 64)) | (1L << (NO - 64)) | (1L << (NULLIF - 64)) | (1L << (NULLS - 64)) | (1L << (ONLY - 64)) | (1L << (OPTION - 64)) | (1L << (ORDINALITY - 64)) | (1L << (OUTPUT - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (PARTITIONS - 128)) | (1L << (POSITION - 128)) | (1L << (PRECEDING - 128)) | (1L << (PRIVILEGES - 128)) | (1L << (PROPERTIES - 128)) | (1L << (PUBLIC - 128)) | (1L << (RANGE - 128)) | (1L << (READ - 128)) | (1L << (RENAME - 128)) | (1L << (REPEATABLE - 128)) | (1L << (REPLACE - 128)) | (1L << (RESET - 128)) | (1L << (RESTRICT - 128)) | (1L << (REVOKE - 128)) | (1L << (ROLLBACK - 128)) | (1L << (ROW - 128)) | (1L << (ROWS - 128)) | (1L << (SCHEMA - 128)) | (1L << (SCHEMAS - 128)) | (1L << (SECOND - 128)) | (1L << (SESSION - 128)) | (1L << (SET - 128)) | (1L << (SETS - 128)) | (1L << (SHOW - 128)) | (1L << (SMALLINT - 128)) | (1L << (SOME - 128)) | (1L << (START - 128)) | (1L << (STATS - 128)) | (1L << (SUBSTRING - 128)) | (1L << (SYSTEM - 128)) | (1L << (TABLES - 128)) | (1L << (TABLESAMPLE - 128)) | (1L << (TEXT - 128)) | (1L << (TIME - 128)) | (1L << (TIMESTAMP - 128)) | (1L << (TINYINT - 128)) | (1L << (TO - 128)) | (1L << (TRY_CAST - 128)) | (1L << (TYPE - 128)) | (1L << (UNBOUNDED - 128)) | (1L << (UNCOMMITTED - 128)) | (1L << (USE - 128)) | (1L << (VALIDATE - 128)) | (1L << (VERBOSE - 128)) | (1L << (VIEW - 128)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (WORK - 194)) | (1L << (WRITE - 194)) | (1L << (YEAR - 194)) | (1L << (ZONE - 194)) | (1L << (IDENTIFIER - 194)) | (1L << (DIGIT_IDENTIFIER - 194)) | (1L << (BACKQUOTED_IDENTIFIER - 194)))) != 0)) {
					{
					setState(244);
					qualifiedName();
					}
				}

				setState(247);
				match(T__1);
				setState(248);
				queryTerm();
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << ALL) | (1L << ANALYZE) | (1L << ANY) | (1L << ARRAY) | (1L << ASC) | (1L << AT) | (1L << BERNOULLI) | (1L << CALL) | (1L << CASCADE) | (1L << CATALOGS) | (1L << COALESCE) | (1L << COLUMN) | (1L << COLUMNS) | (1L << COMMENT) | (1L << COMMIT) | (1L << COMMITTED) | (1L << CURRENT) | (1L << DATA) | (1L << DATE) | (1L << DAY) | (1L << DESC) | (1L << DISTRIBUTED) | (1L << EXCLUDING) | (1L << EXPLAIN) | (1L << FILTER))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FIRST - 64)) | (1L << (FOLLOWING - 64)) | (1L << (FORMAT - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (GRANT - 64)) | (1L << (GRANTS - 64)) | (1L << (GRAPHVIZ - 64)) | (1L << (HOUR - 64)) | (1L << (IF - 64)) | (1L << (INCLUDING - 64)) | (1L << (INPUT - 64)) | (1L << (INTEGER - 64)) | (1L << (INTERVAL - 64)) | (1L << (ISOLATION - 64)) | (1L << (LAST - 64)) | (1L << (LATERAL - 64)) | (1L << (LEVEL - 64)) | (1L << (LIMIT - 64)) | (1L << (LOGICAL - 64)) | (1L << (MAP - 64)) | (1L << (MINUTE - 64)) | (1L << (MONTH - 64)) | (1L << (NFC - 64)) | (1L << (NFD - 64)) | (1L << (NFKC - 64)) | (1L << (NFKD - 64)) | (1L << (NO - 64)) | (1L << (NULLIF - 64)) | (1L << (NULLS - 64)) | (1L << (ONLY - 64)) | (1L << (OPTION - 64)) | (1L << (ORDINALITY - 64)) | (1L << (OUTPUT - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (PARTITIONS - 128)) | (1L << (POSITION - 128)) | (1L << (PRECEDING - 128)) | (1L << (PRIVILEGES - 128)) | (1L << (PROPERTIES - 128)) | (1L << (PUBLIC - 128)) | (1L << (RANGE - 128)) | (1L << (READ - 128)) | (1L << (RENAME - 128)) | (1L << (REPEATABLE - 128)) | (1L << (REPLACE - 128)) | (1L << (RESET - 128)) | (1L << (RESTRICT - 128)) | (1L << (REVOKE - 128)) | (1L << (ROLLBACK - 128)) | (1L << (ROW - 128)) | (1L << (ROWS - 128)) | (1L << (SCHEMA - 128)) | (1L << (SCHEMAS - 128)) | (1L << (SECOND - 128)) | (1L << (SESSION - 128)) | (1L << (SET - 128)) | (1L << (SETS - 128)) | (1L << (SHOW - 128)) | (1L << (SMALLINT - 128)) | (1L << (SOME - 128)) | (1L << (START - 128)) | (1L << (STATS - 128)) | (1L << (SUBSTRING - 128)) | (1L << (SYSTEM - 128)) | (1L << (TABLES - 128)) | (1L << (TABLESAMPLE - 128)) | (1L << (TEXT - 128)) | (1L << (TIME - 128)) | (1L << (TIMESTAMP - 128)) | (1L << (TINYINT - 128)) | (1L << (TO - 128)) | (1L << (TRY_CAST - 128)) | (1L << (TYPE - 128)) | (1L << (UNBOUNDED - 128)) | (1L << (UNCOMMITTED - 128)) | (1L << (USE - 128)) | (1L << (VALIDATE - 128)) | (1L << (VERBOSE - 128)) | (1L << (VIEW - 128)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (WORK - 194)) | (1L << (WRITE - 194)) | (1L << (YEAR - 194)) | (1L << (ZONE - 194)) | (1L << (IDENTIFIER - 194)) | (1L << (DIGIT_IDENTIFIER - 194)) | (1L << (BACKQUOTED_IDENTIFIER - 194)))) != 0)) {
					{
					setState(249);
					qualifiedName();
					}
				}

				setState(252);
				match(ON);
				setState(255);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ADD:
				case ALL:
				case ANALYZE:
				case ANY:
				case ARRAY:
				case ASC:
				case AT:
				case BERNOULLI:
				case CALL:
				case CASCADE:
				case CATALOGS:
				case COALESCE:
				case COLUMN:
				case COLUMNS:
				case COMMENT:
				case COMMIT:
				case COMMITTED:
				case CURRENT:
				case DATA:
				case DATE:
				case DAY:
				case DESC:
				case DISTRIBUTED:
				case EXCLUDING:
				case EXPLAIN:
				case FILTER:
				case FIRST:
				case FOLLOWING:
				case FORMAT:
				case FUNCTIONS:
				case GRANT:
				case GRANTS:
				case GRAPHVIZ:
				case HOUR:
				case IF:
				case INCLUDING:
				case INPUT:
				case INTEGER:
				case INTERVAL:
				case ISOLATION:
				case LAST:
				case LATERAL:
				case LEVEL:
				case LIMIT:
				case LOGICAL:
				case MAP:
				case MINUTE:
				case MONTH:
				case NFC:
				case NFD:
				case NFKC:
				case NFKD:
				case NO:
				case NULLIF:
				case NULLS:
				case ONLY:
				case OPTION:
				case ORDINALITY:
				case OUTPUT:
				case OVER:
				case PARTITION:
				case PARTITIONS:
				case POSITION:
				case PRECEDING:
				case PRIVILEGES:
				case PROPERTIES:
				case PUBLIC:
				case RANGE:
				case READ:
				case RENAME:
				case REPEATABLE:
				case REPLACE:
				case RESET:
				case RESTRICT:
				case REVOKE:
				case ROLLBACK:
				case ROW:
				case ROWS:
				case SCHEMA:
				case SCHEMAS:
				case SECOND:
				case SESSION:
				case SET:
				case SETS:
				case SHOW:
				case SMALLINT:
				case SOME:
				case START:
				case STATS:
				case SUBSTRING:
				case SYSTEM:
				case TABLES:
				case TABLESAMPLE:
				case TEXT:
				case TIME:
				case TIMESTAMP:
				case TINYINT:
				case TO:
				case TRY_CAST:
				case TYPE:
				case UNBOUNDED:
				case UNCOMMITTED:
				case USE:
				case VALIDATE:
				case VERBOSE:
				case VIEW:
				case WORK:
				case WRITE:
				case YEAR:
				case ZONE:
				case IDENTIFIER:
				case DIGIT_IDENTIFIER:
				case BACKQUOTED_IDENTIFIER:
					{
					setState(253);
					columnAliases();
					}
					break;
				case ASTERISK:
					{
					setState(254);
					match(ASTERISK);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(257);
					match(WITH);
					setState(270);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						setState(259);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MIN) {
							{
							setState(258);
							minRatioExpression();
							}
						}

						setState(262);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MIN_SUPPORT) {
							{
							setState(261);
							minSupportExpression();
							}
						}

						}
						break;
					case 2:
						{
						setState(265);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MIN_SUPPORT) {
							{
							setState(264);
							minSupportExpression();
							}
						}

						setState(268);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MIN) {
							{
							setState(267);
							minRatioExpression();
							}
						}

						}
						break;
					}
					}
				}

				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMPARE) {
					{
					setState(274);
					match(COMPARE);
					setState(275);
					match(BY);
					setState(276);
					ratioMetricExpression();
					}
				}

				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MAX) {
					{
					setState(279);
					match(MAX);
					setState(280);
					match(COMBO);
					setState(281);
					((DiffQuerySpecificationContext)_localctx).maxCombo = match(INTEGER_VALUE);
					}
				}

				setState(286);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(284);
					match(WHERE);
					setState(285);
					((DiffQuerySpecificationContext)_localctx).where = booleanExpression(0);
					}
					break;
				}
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER) {
					{
					setState(288);
					match(ORDER);
					setState(289);
					match(BY);
					setState(290);
					sortItem();
					setState(295);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(291);
							match(T__1);
							setState(292);
							sortItem();
							}
							} 
						}
						setState(297);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
					}
					}
				}

				setState(302);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(300);
					match(LIMIT);
					setState(301);
					((DiffQuerySpecificationContext)_localctx).limit = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==INTEGER_VALUE) ) {
						((DiffQuerySpecificationContext)_localctx).limit = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTO) {
					{
					setState(304);
					exportClause();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
				match(SELECT);
				setState(309);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(308);
					setQuantifier();
					}
					break;
				}
				setState(311);
				selectItem();
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(312);
					match(T__1);
					setState(313);
					selectItem();
					}
					}
					setState(318);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTO) {
					{
					setState(319);
					exportClause();
					}
				}

				setState(322);
				match(FROM);
				setState(323);
				match(DIFF);
				setState(324);
				queryTerm();
				setState(326);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << ALL) | (1L << ANALYZE) | (1L << ANY) | (1L << ARRAY) | (1L << ASC) | (1L << AT) | (1L << BERNOULLI) | (1L << CALL) | (1L << CASCADE) | (1L << CATALOGS) | (1L << COALESCE) | (1L << COLUMN) | (1L << COLUMNS) | (1L << COMMENT) | (1L << COMMIT) | (1L << COMMITTED) | (1L << CURRENT) | (1L << DATA) | (1L << DATE) | (1L << DAY) | (1L << DESC) | (1L << DISTRIBUTED) | (1L << EXCLUDING) | (1L << EXPLAIN) | (1L << FILTER))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FIRST - 64)) | (1L << (FOLLOWING - 64)) | (1L << (FORMAT - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (GRANT - 64)) | (1L << (GRANTS - 64)) | (1L << (GRAPHVIZ - 64)) | (1L << (HOUR - 64)) | (1L << (IF - 64)) | (1L << (INCLUDING - 64)) | (1L << (INPUT - 64)) | (1L << (INTEGER - 64)) | (1L << (INTERVAL - 64)) | (1L << (ISOLATION - 64)) | (1L << (LAST - 64)) | (1L << (LATERAL - 64)) | (1L << (LEVEL - 64)) | (1L << (LIMIT - 64)) | (1L << (LOGICAL - 64)) | (1L << (MAP - 64)) | (1L << (MINUTE - 64)) | (1L << (MONTH - 64)) | (1L << (NFC - 64)) | (1L << (NFD - 64)) | (1L << (NFKC - 64)) | (1L << (NFKD - 64)) | (1L << (NO - 64)) | (1L << (NULLIF - 64)) | (1L << (NULLS - 64)) | (1L << (ONLY - 64)) | (1L << (OPTION - 64)) | (1L << (ORDINALITY - 64)) | (1L << (OUTPUT - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (PARTITIONS - 128)) | (1L << (POSITION - 128)) | (1L << (PRECEDING - 128)) | (1L << (PRIVILEGES - 128)) | (1L << (PROPERTIES - 128)) | (1L << (PUBLIC - 128)) | (1L << (RANGE - 128)) | (1L << (READ - 128)) | (1L << (RENAME - 128)) | (1L << (REPEATABLE - 128)) | (1L << (REPLACE - 128)) | (1L << (RESET - 128)) | (1L << (RESTRICT - 128)) | (1L << (REVOKE - 128)) | (1L << (ROLLBACK - 128)) | (1L << (ROW - 128)) | (1L << (ROWS - 128)) | (1L << (SCHEMA - 128)) | (1L << (SCHEMAS - 128)) | (1L << (SECOND - 128)) | (1L << (SESSION - 128)) | (1L << (SET - 128)) | (1L << (SETS - 128)) | (1L << (SHOW - 128)) | (1L << (SMALLINT - 128)) | (1L << (SOME - 128)) | (1L << (START - 128)) | (1L << (STATS - 128)) | (1L << (SUBSTRING - 128)) | (1L << (SYSTEM - 128)) | (1L << (TABLES - 128)) | (1L << (TABLESAMPLE - 128)) | (1L << (TEXT - 128)) | (1L << (TIME - 128)) | (1L << (TIMESTAMP - 128)) | (1L << (TINYINT - 128)) | (1L << (TO - 128)) | (1L << (TRY_CAST - 128)) | (1L << (TYPE - 128)) | (1L << (UNBOUNDED - 128)) | (1L << (UNCOMMITTED - 128)) | (1L << (USE - 128)) | (1L << (VALIDATE - 128)) | (1L << (VERBOSE - 128)) | (1L << (VIEW - 128)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (WORK - 194)) | (1L << (WRITE - 194)) | (1L << (YEAR - 194)) | (1L << (ZONE - 194)) | (1L << (IDENTIFIER - 194)) | (1L << (DIGIT_IDENTIFIER - 194)) | (1L << (BACKQUOTED_IDENTIFIER - 194)))) != 0)) {
					{
					setState(325);
					qualifiedName();
					}
				}

				setState(328);
				match(T__1);
				setState(329);
				queryTerm();
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << ALL) | (1L << ANALYZE) | (1L << ANY) | (1L << ARRAY) | (1L << ASC) | (1L << AT) | (1L << BERNOULLI) | (1L << CALL) | (1L << CASCADE) | (1L << CATALOGS) | (1L << COALESCE) | (1L << COLUMN) | (1L << COLUMNS) | (1L << COMMENT) | (1L << COMMIT) | (1L << COMMITTED) | (1L << CURRENT) | (1L << DATA) | (1L << DATE) | (1L << DAY) | (1L << DESC) | (1L << DISTRIBUTED) | (1L << EXCLUDING) | (1L << EXPLAIN) | (1L << FILTER))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FIRST - 64)) | (1L << (FOLLOWING - 64)) | (1L << (FORMAT - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (GRANT - 64)) | (1L << (GRANTS - 64)) | (1L << (GRAPHVIZ - 64)) | (1L << (HOUR - 64)) | (1L << (IF - 64)) | (1L << (INCLUDING - 64)) | (1L << (INPUT - 64)) | (1L << (INTEGER - 64)) | (1L << (INTERVAL - 64)) | (1L << (ISOLATION - 64)) | (1L << (LAST - 64)) | (1L << (LATERAL - 64)) | (1L << (LEVEL - 64)) | (1L << (LIMIT - 64)) | (1L << (LOGICAL - 64)) | (1L << (MAP - 64)) | (1L << (MINUTE - 64)) | (1L << (MONTH - 64)) | (1L << (NFC - 64)) | (1L << (NFD - 64)) | (1L << (NFKC - 64)) | (1L << (NFKD - 64)) | (1L << (NO - 64)) | (1L << (NULLIF - 64)) | (1L << (NULLS - 64)) | (1L << (ONLY - 64)) | (1L << (OPTION - 64)) | (1L << (ORDINALITY - 64)) | (1L << (OUTPUT - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (PARTITIONS - 128)) | (1L << (POSITION - 128)) | (1L << (PRECEDING - 128)) | (1L << (PRIVILEGES - 128)) | (1L << (PROPERTIES - 128)) | (1L << (PUBLIC - 128)) | (1L << (RANGE - 128)) | (1L << (READ - 128)) | (1L << (RENAME - 128)) | (1L << (REPEATABLE - 128)) | (1L << (REPLACE - 128)) | (1L << (RESET - 128)) | (1L << (RESTRICT - 128)) | (1L << (REVOKE - 128)) | (1L << (ROLLBACK - 128)) | (1L << (ROW - 128)) | (1L << (ROWS - 128)) | (1L << (SCHEMA - 128)) | (1L << (SCHEMAS - 128)) | (1L << (SECOND - 128)) | (1L << (SESSION - 128)) | (1L << (SET - 128)) | (1L << (SETS - 128)) | (1L << (SHOW - 128)) | (1L << (SMALLINT - 128)) | (1L << (SOME - 128)) | (1L << (START - 128)) | (1L << (STATS - 128)) | (1L << (SUBSTRING - 128)) | (1L << (SYSTEM - 128)) | (1L << (TABLES - 128)) | (1L << (TABLESAMPLE - 128)) | (1L << (TEXT - 128)) | (1L << (TIME - 128)) | (1L << (TIMESTAMP - 128)) | (1L << (TINYINT - 128)) | (1L << (TO - 128)) | (1L << (TRY_CAST - 128)) | (1L << (TYPE - 128)) | (1L << (UNBOUNDED - 128)) | (1L << (UNCOMMITTED - 128)) | (1L << (USE - 128)) | (1L << (VALIDATE - 128)) | (1L << (VERBOSE - 128)) | (1L << (VIEW - 128)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (WORK - 194)) | (1L << (WRITE - 194)) | (1L << (YEAR - 194)) | (1L << (ZONE - 194)) | (1L << (IDENTIFIER - 194)) | (1L << (DIGIT_IDENTIFIER - 194)) | (1L << (BACKQUOTED_IDENTIFIER - 194)))) != 0)) {
					{
					setState(330);
					qualifiedName();
					}
				}

				setState(333);
				match(ON);
				setState(336);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ADD:
				case ALL:
				case ANALYZE:
				case ANY:
				case ARRAY:
				case ASC:
				case AT:
				case BERNOULLI:
				case CALL:
				case CASCADE:
				case CATALOGS:
				case COALESCE:
				case COLUMN:
				case COLUMNS:
				case COMMENT:
				case COMMIT:
				case COMMITTED:
				case CURRENT:
				case DATA:
				case DATE:
				case DAY:
				case DESC:
				case DISTRIBUTED:
				case EXCLUDING:
				case EXPLAIN:
				case FILTER:
				case FIRST:
				case FOLLOWING:
				case FORMAT:
				case FUNCTIONS:
				case GRANT:
				case GRANTS:
				case GRAPHVIZ:
				case HOUR:
				case IF:
				case INCLUDING:
				case INPUT:
				case INTEGER:
				case INTERVAL:
				case ISOLATION:
				case LAST:
				case LATERAL:
				case LEVEL:
				case LIMIT:
				case LOGICAL:
				case MAP:
				case MINUTE:
				case MONTH:
				case NFC:
				case NFD:
				case NFKC:
				case NFKD:
				case NO:
				case NULLIF:
				case NULLS:
				case ONLY:
				case OPTION:
				case ORDINALITY:
				case OUTPUT:
				case OVER:
				case PARTITION:
				case PARTITIONS:
				case POSITION:
				case PRECEDING:
				case PRIVILEGES:
				case PROPERTIES:
				case PUBLIC:
				case RANGE:
				case READ:
				case RENAME:
				case REPEATABLE:
				case REPLACE:
				case RESET:
				case RESTRICT:
				case REVOKE:
				case ROLLBACK:
				case ROW:
				case ROWS:
				case SCHEMA:
				case SCHEMAS:
				case SECOND:
				case SESSION:
				case SET:
				case SETS:
				case SHOW:
				case SMALLINT:
				case SOME:
				case START:
				case STATS:
				case SUBSTRING:
				case SYSTEM:
				case TABLES:
				case TABLESAMPLE:
				case TEXT:
				case TIME:
				case TIMESTAMP:
				case TINYINT:
				case TO:
				case TRY_CAST:
				case TYPE:
				case UNBOUNDED:
				case UNCOMMITTED:
				case USE:
				case VALIDATE:
				case VERBOSE:
				case VIEW:
				case WORK:
				case WRITE:
				case YEAR:
				case ZONE:
				case IDENTIFIER:
				case DIGIT_IDENTIFIER:
				case BACKQUOTED_IDENTIFIER:
					{
					setState(334);
					columnAliases();
					}
					break;
				case ASTERISK:
					{
					setState(335);
					match(ASTERISK);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(338);
					match(WITH);
					setState(351);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
					case 1:
						{
						setState(340);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MIN) {
							{
							setState(339);
							minRatioExpression();
							}
						}

						setState(343);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MIN_SUPPORT) {
							{
							setState(342);
							minSupportExpression();
							}
						}

						}
						break;
					case 2:
						{
						setState(346);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MIN_SUPPORT) {
							{
							setState(345);
							minSupportExpression();
							}
						}

						setState(349);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MIN) {
							{
							setState(348);
							minRatioExpression();
							}
						}

						}
						break;
					}
					}
				}

				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMPARE) {
					{
					setState(355);
					match(COMPARE);
					setState(356);
					match(BY);
					setState(357);
					ratioMetricExpression();
					}
				}

				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MAX) {
					{
					setState(360);
					match(MAX);
					setState(361);
					match(COMBO);
					setState(362);
					((DiffQuerySpecificationContext)_localctx).maxCombo = match(INTEGER_VALUE);
					}
				}

				setState(367);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
				case 1:
					{
					setState(365);
					match(WHERE);
					setState(366);
					((DiffQuerySpecificationContext)_localctx).where = booleanExpression(0);
					}
					break;
				}
				setState(379);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER) {
					{
					setState(369);
					match(ORDER);
					setState(370);
					match(BY);
					setState(371);
					sortItem();
					setState(376);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(372);
							match(T__1);
							setState(373);
							sortItem();
							}
							} 
						}
						setState(378);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
					}
					}
				}

				setState(383);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
				case 1:
					{
					setState(381);
					match(LIMIT);
					setState(382);
					((DiffQuerySpecificationContext)_localctx).limit = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==INTEGER_VALUE) ) {
						((DiffQuerySpecificationContext)_localctx).limit = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(385);
				match(SELECT);
				setState(387);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(386);
					setQuantifier();
					}
					break;
				}
				setState(389);
				selectItem();
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(390);
					match(T__1);
					setState(391);
					selectItem();
					}
					}
					setState(396);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(397);
				match(FROM);
				setState(398);
				match(DIFF);
				setState(399);
				match(T__0);
				setState(400);
				splitQuery();
				setState(401);
				match(T__2);
				setState(402);
				match(ON);
				setState(405);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ADD:
				case ALL:
				case ANALYZE:
				case ANY:
				case ARRAY:
				case ASC:
				case AT:
				case BERNOULLI:
				case CALL:
				case CASCADE:
				case CATALOGS:
				case COALESCE:
				case COLUMN:
				case COLUMNS:
				case COMMENT:
				case COMMIT:
				case COMMITTED:
				case CURRENT:
				case DATA:
				case DATE:
				case DAY:
				case DESC:
				case DISTRIBUTED:
				case EXCLUDING:
				case EXPLAIN:
				case FILTER:
				case FIRST:
				case FOLLOWING:
				case FORMAT:
				case FUNCTIONS:
				case GRANT:
				case GRANTS:
				case GRAPHVIZ:
				case HOUR:
				case IF:
				case INCLUDING:
				case INPUT:
				case INTEGER:
				case INTERVAL:
				case ISOLATION:
				case LAST:
				case LATERAL:
				case LEVEL:
				case LIMIT:
				case LOGICAL:
				case MAP:
				case MINUTE:
				case MONTH:
				case NFC:
				case NFD:
				case NFKC:
				case NFKD:
				case NO:
				case NULLIF:
				case NULLS:
				case ONLY:
				case OPTION:
				case ORDINALITY:
				case OUTPUT:
				case OVER:
				case PARTITION:
				case PARTITIONS:
				case POSITION:
				case PRECEDING:
				case PRIVILEGES:
				case PROPERTIES:
				case PUBLIC:
				case RANGE:
				case READ:
				case RENAME:
				case REPEATABLE:
				case REPLACE:
				case RESET:
				case RESTRICT:
				case REVOKE:
				case ROLLBACK:
				case ROW:
				case ROWS:
				case SCHEMA:
				case SCHEMAS:
				case SECOND:
				case SESSION:
				case SET:
				case SETS:
				case SHOW:
				case SMALLINT:
				case SOME:
				case START:
				case STATS:
				case SUBSTRING:
				case SYSTEM:
				case TABLES:
				case TABLESAMPLE:
				case TEXT:
				case TIME:
				case TIMESTAMP:
				case TINYINT:
				case TO:
				case TRY_CAST:
				case TYPE:
				case UNBOUNDED:
				case UNCOMMITTED:
				case USE:
				case VALIDATE:
				case VERBOSE:
				case VIEW:
				case WORK:
				case WRITE:
				case YEAR:
				case ZONE:
				case IDENTIFIER:
				case DIGIT_IDENTIFIER:
				case BACKQUOTED_IDENTIFIER:
					{
					setState(403);
					columnAliases();
					}
					break;
				case ASTERISK:
					{
					setState(404);
					match(ASTERISK);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(422);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(407);
					match(WITH);
					setState(420);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
					case 1:
						{
						setState(409);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MIN) {
							{
							setState(408);
							minRatioExpression();
							}
						}

						setState(412);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MIN_SUPPORT) {
							{
							setState(411);
							minSupportExpression();
							}
						}

						}
						break;
					case 2:
						{
						setState(415);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MIN_SUPPORT) {
							{
							setState(414);
							minSupportExpression();
							}
						}

						setState(418);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MIN) {
							{
							setState(417);
							minRatioExpression();
							}
						}

						}
						break;
					}
					}
				}

				setState(427);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMPARE) {
					{
					setState(424);
					match(COMPARE);
					setState(425);
					match(BY);
					setState(426);
					ratioMetricExpression();
					}
				}

				setState(432);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MAX) {
					{
					setState(429);
					match(MAX);
					setState(430);
					match(COMBO);
					setState(431);
					((DiffQuerySpecificationContext)_localctx).maxCombo = match(INTEGER_VALUE);
					}
				}

				setState(436);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
				case 1:
					{
					setState(434);
					match(WHERE);
					setState(435);
					((DiffQuerySpecificationContext)_localctx).where = booleanExpression(0);
					}
					break;
				}
				setState(448);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER) {
					{
					setState(438);
					match(ORDER);
					setState(439);
					match(BY);
					setState(440);
					sortItem();
					setState(445);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(441);
							match(T__1);
							setState(442);
							sortItem();
							}
							} 
						}
						setState(447);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
					}
					}
				}

				setState(452);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
				case 1:
					{
					setState(450);
					match(LIMIT);
					setState(451);
					((DiffQuerySpecificationContext)_localctx).limit = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==INTEGER_VALUE) ) {
						((DiffQuerySpecificationContext)_localctx).limit = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(455);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTO) {
					{
					setState(454);
					exportClause();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(457);
				match(SELECT);
				setState(459);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
				case 1:
					{
					setState(458);
					setQuantifier();
					}
					break;
				}
				setState(461);
				selectItem();
				setState(466);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(462);
					match(T__1);
					setState(463);
					selectItem();
					}
					}
					setState(468);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(470);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTO) {
					{
					setState(469);
					exportClause();
					}
				}

				setState(472);
				match(FROM);
				setState(473);
				match(DIFF);
				setState(474);
				match(T__0);
				setState(475);
				splitQuery();
				setState(476);
				match(T__2);
				setState(477);
				match(ON);
				setState(480);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ADD:
				case ALL:
				case ANALYZE:
				case ANY:
				case ARRAY:
				case ASC:
				case AT:
				case BERNOULLI:
				case CALL:
				case CASCADE:
				case CATALOGS:
				case COALESCE:
				case COLUMN:
				case COLUMNS:
				case COMMENT:
				case COMMIT:
				case COMMITTED:
				case CURRENT:
				case DATA:
				case DATE:
				case DAY:
				case DESC:
				case DISTRIBUTED:
				case EXCLUDING:
				case EXPLAIN:
				case FILTER:
				case FIRST:
				case FOLLOWING:
				case FORMAT:
				case FUNCTIONS:
				case GRANT:
				case GRANTS:
				case GRAPHVIZ:
				case HOUR:
				case IF:
				case INCLUDING:
				case INPUT:
				case INTEGER:
				case INTERVAL:
				case ISOLATION:
				case LAST:
				case LATERAL:
				case LEVEL:
				case LIMIT:
				case LOGICAL:
				case MAP:
				case MINUTE:
				case MONTH:
				case NFC:
				case NFD:
				case NFKC:
				case NFKD:
				case NO:
				case NULLIF:
				case NULLS:
				case ONLY:
				case OPTION:
				case ORDINALITY:
				case OUTPUT:
				case OVER:
				case PARTITION:
				case PARTITIONS:
				case POSITION:
				case PRECEDING:
				case PRIVILEGES:
				case PROPERTIES:
				case PUBLIC:
				case RANGE:
				case READ:
				case RENAME:
				case REPEATABLE:
				case REPLACE:
				case RESET:
				case RESTRICT:
				case REVOKE:
				case ROLLBACK:
				case ROW:
				case ROWS:
				case SCHEMA:
				case SCHEMAS:
				case SECOND:
				case SESSION:
				case SET:
				case SETS:
				case SHOW:
				case SMALLINT:
				case SOME:
				case START:
				case STATS:
				case SUBSTRING:
				case SYSTEM:
				case TABLES:
				case TABLESAMPLE:
				case TEXT:
				case TIME:
				case TIMESTAMP:
				case TINYINT:
				case TO:
				case TRY_CAST:
				case TYPE:
				case UNBOUNDED:
				case UNCOMMITTED:
				case USE:
				case VALIDATE:
				case VERBOSE:
				case VIEW:
				case WORK:
				case WRITE:
				case YEAR:
				case ZONE:
				case IDENTIFIER:
				case DIGIT_IDENTIFIER:
				case BACKQUOTED_IDENTIFIER:
					{
					setState(478);
					columnAliases();
					}
					break;
				case ASTERISK:
					{
					setState(479);
					match(ASTERISK);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(497);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(482);
					match(WITH);
					setState(495);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
					case 1:
						{
						setState(484);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MIN) {
							{
							setState(483);
							minRatioExpression();
							}
						}

						setState(487);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MIN_SUPPORT) {
							{
							setState(486);
							minSupportExpression();
							}
						}

						}
						break;
					case 2:
						{
						setState(490);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MIN_SUPPORT) {
							{
							setState(489);
							minSupportExpression();
							}
						}

						setState(493);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MIN) {
							{
							setState(492);
							minRatioExpression();
							}
						}

						}
						break;
					}
					}
				}

				setState(502);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMPARE) {
					{
					setState(499);
					match(COMPARE);
					setState(500);
					match(BY);
					setState(501);
					ratioMetricExpression();
					}
				}

				setState(507);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MAX) {
					{
					setState(504);
					match(MAX);
					setState(505);
					match(COMBO);
					setState(506);
					((DiffQuerySpecificationContext)_localctx).maxCombo = match(INTEGER_VALUE);
					}
				}

				setState(511);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
				case 1:
					{
					setState(509);
					match(WHERE);
					setState(510);
					((DiffQuerySpecificationContext)_localctx).where = booleanExpression(0);
					}
					break;
				}
				setState(523);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER) {
					{
					setState(513);
					match(ORDER);
					setState(514);
					match(BY);
					setState(515);
					sortItem();
					setState(520);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(516);
							match(T__1);
							setState(517);
							sortItem();
							}
							} 
						}
						setState(522);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
					}
					}
				}

				setState(527);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
				case 1:
					{
					setState(525);
					match(LIMIT);
					setState(526);
					((DiffQuerySpecificationContext)_localctx).limit = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==INTEGER_VALUE) ) {
						((DiffQuerySpecificationContext)_localctx).limit = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SplitQueryContext extends ParserRuleContext {
		public BooleanExpressionContext where;
		public TerminalNode SPLIT() { return getToken(SqlBaseParser.SPLIT, 0); }
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(SqlBaseParser.WHERE, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public QueryTermContext queryTerm() {
			return getRuleContext(QueryTermContext.class,0);
		}
		public SplitQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_splitQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSplitQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSplitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSplitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SplitQueryContext splitQuery() throws RecognitionException {
		SplitQueryContext _localctx = new SplitQueryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_splitQuery);
		try {
			setState(541);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(531);
				match(SPLIT);
				setState(532);
				relation();
				setState(533);
				match(WHERE);
				setState(534);
				((SplitQueryContext)_localctx).where = booleanExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(536);
				match(SPLIT);
				setState(537);
				queryTerm();
				setState(538);
				match(WHERE);
				setState(539);
				((SplitQueryContext)_localctx).where = booleanExpression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnDefinitionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(SqlBaseParser.COMMENT, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public ColumnDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterColumnDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitColumnDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitColumnDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnDefinitionContext columnDefinition() throws RecognitionException {
		ColumnDefinitionContext _localctx = new ColumnDefinitionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_columnDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			identifier();
			setState(544);
			type(0);
			setState(547);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(545);
				match(COMMENT);
				setState(546);
				string();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SortItemContext extends ParserRuleContext {
		public Token ordering;
		public Token nullOrdering;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NULLS() { return getToken(SqlBaseParser.NULLS, 0); }
		public TerminalNode ASC() { return getToken(SqlBaseParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(SqlBaseParser.DESC, 0); }
		public TerminalNode FIRST() { return getToken(SqlBaseParser.FIRST, 0); }
		public TerminalNode LAST() { return getToken(SqlBaseParser.LAST, 0); }
		public SortItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSortItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSortItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSortItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortItemContext sortItem() throws RecognitionException {
		SortItemContext _localctx = new SortItemContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sortItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			expression();
			setState(551);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				{
				setState(550);
				((SortItemContext)_localctx).ordering = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
					((SortItemContext)_localctx).ordering = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			setState(555);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				{
				setState(553);
				match(NULLS);
				setState(554);
				((SortItemContext)_localctx).nullOrdering = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==FIRST || _la==LAST) ) {
					((SortItemContext)_localctx).nullOrdering = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MinRatioExpressionContext extends ParserRuleContext {
		public Token minRatio;
		public TerminalNode MIN() { return getToken(SqlBaseParser.MIN, 0); }
		public TerminalNode RATIO() { return getToken(SqlBaseParser.RATIO, 0); }
		public TerminalNode DECIMAL_VALUE() { return getToken(SqlBaseParser.DECIMAL_VALUE, 0); }
		public MinRatioExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minRatioExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterMinRatioExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitMinRatioExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitMinRatioExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MinRatioExpressionContext minRatioExpression() throws RecognitionException {
		MinRatioExpressionContext _localctx = new MinRatioExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_minRatioExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			match(MIN);
			setState(558);
			match(RATIO);
			setState(559);
			((MinRatioExpressionContext)_localctx).minRatio = match(DECIMAL_VALUE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MinSupportExpressionContext extends ParserRuleContext {
		public Token minSupport;
		public TerminalNode MIN_SUPPORT() { return getToken(SqlBaseParser.MIN_SUPPORT, 0); }
		public TerminalNode DECIMAL_VALUE() { return getToken(SqlBaseParser.DECIMAL_VALUE, 0); }
		public MinSupportExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minSupportExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterMinSupportExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitMinSupportExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitMinSupportExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MinSupportExpressionContext minSupportExpression() throws RecognitionException {
		MinSupportExpressionContext _localctx = new MinSupportExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_minSupportExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			match(MIN_SUPPORT);
			setState(562);
			((MinSupportExpressionContext)_localctx).minSupport = match(DECIMAL_VALUE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RatioMetricExpressionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AggregateExpressionContext aggregateExpression() {
			return getRuleContext(AggregateExpressionContext.class,0);
		}
		public RatioMetricExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ratioMetricExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterRatioMetricExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitRatioMetricExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitRatioMetricExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RatioMetricExpressionContext ratioMetricExpression() throws RecognitionException {
		RatioMetricExpressionContext _localctx = new RatioMetricExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ratioMetricExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			identifier();
			setState(565);
			match(T__0);
			setState(566);
			aggregateExpression();
			setState(567);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AggregateExpressionContext extends ParserRuleContext {
		public AggregateContext aggregate() {
			return getRuleContext(AggregateContext.class,0);
		}
		public TerminalNode ASTERISK() { return getToken(SqlBaseParser.ASTERISK, 0); }
		public AggregateExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregateExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterAggregateExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitAggregateExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitAggregateExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggregateExpressionContext aggregateExpression() throws RecognitionException {
		AggregateExpressionContext _localctx = new AggregateExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_aggregateExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(569);
			aggregate();
			setState(570);
			match(T__0);
			setState(571);
			match(ASTERISK);
			setState(572);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AggregateContext extends ParserRuleContext {
		public TerminalNode COUNT() { return getToken(SqlBaseParser.COUNT, 0); }
		public TerminalNode MIN() { return getToken(SqlBaseParser.MIN, 0); }
		public TerminalNode MAX() { return getToken(SqlBaseParser.MAX, 0); }
		public TerminalNode SUM() { return getToken(SqlBaseParser.SUM, 0); }
		public AggregateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterAggregate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitAggregate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitAggregate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggregateContext aggregate() throws RecognitionException {
		AggregateContext _localctx = new AggregateContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_aggregate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(574);
			_la = _input.LA(1);
			if ( !(_la==COUNT || _la==MAX || _la==MIN || _la==SUM) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetQuantifierContext extends ParserRuleContext {
		public TerminalNode DISTINCT() { return getToken(SqlBaseParser.DISTINCT, 0); }
		public TerminalNode ALL() { return getToken(SqlBaseParser.ALL, 0); }
		public SetQuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setQuantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSetQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSetQuantifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSetQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetQuantifierContext setQuantifier() throws RecognitionException {
		SetQuantifierContext _localctx = new SetQuantifierContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_setQuantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			_la = _input.LA(1);
			if ( !(_la==ALL || _la==DISTINCT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectItemContext extends ParserRuleContext {
		public SelectItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectItem; }
	 
		public SelectItemContext() { }
		public void copyFrom(SelectItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SelectAllContext extends SelectItemContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode ASTERISK() { return getToken(SqlBaseParser.ASTERISK, 0); }
		public SelectAllContext(SelectItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSelectAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSelectAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSelectAll(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelectSingleContext extends SelectItemContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public SelectSingleContext(SelectItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSelectSingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSelectSingle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSelectSingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectItemContext selectItem() throws RecognitionException {
		SelectItemContext _localctx = new SelectItemContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_selectItem);
		int _la;
		try {
			setState(590);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				_localctx = new SelectSingleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(578);
				expression();
				setState(583);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
				case 1:
					{
					setState(580);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(579);
						match(AS);
						}
					}

					setState(582);
					identifier();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new SelectAllContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(585);
				qualifiedName();
				setState(586);
				match(T__3);
				setState(587);
				match(ASTERISK);
				}
				break;
			case 3:
				_localctx = new SelectAllContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(589);
				match(ASTERISK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExportClauseContext extends ParserRuleContext {
		public Token filename;
		public Token fieldsFormat;
		public TerminalNode INTO() { return getToken(SqlBaseParser.INTO, 0); }
		public TerminalNode OUTFILE() { return getToken(SqlBaseParser.OUTFILE, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public List<DelimiterClauseContext> delimiterClause() {
			return getRuleContexts(DelimiterClauseContext.class);
		}
		public DelimiterClauseContext delimiterClause(int i) {
			return getRuleContext(DelimiterClauseContext.class,i);
		}
		public TerminalNode LINES() { return getToken(SqlBaseParser.LINES, 0); }
		public TerminalNode FIELDS() { return getToken(SqlBaseParser.FIELDS, 0); }
		public TerminalNode COLUMNS() { return getToken(SqlBaseParser.COLUMNS, 0); }
		public ExportClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exportClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterExportClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitExportClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitExportClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExportClauseContext exportClause() throws RecognitionException {
		ExportClauseContext _localctx = new ExportClauseContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_exportClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(592);
			match(INTO);
			setState(593);
			match(OUTFILE);
			setState(594);
			((ExportClauseContext)_localctx).filename = match(STRING);
			setState(597);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				{
				setState(595);
				((ExportClauseContext)_localctx).fieldsFormat = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==COLUMNS || _la==FIELDS) ) {
					((ExportClauseContext)_localctx).fieldsFormat = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(596);
				delimiterClause();
				}
				break;
			}
			setState(601);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LINES) {
				{
				setState(599);
				match(LINES);
				setState(600);
				delimiterClause();
				}
			}

			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DelimiterClauseContext extends ParserRuleContext {
		public Token delimiter;
		public TerminalNode TERMINATED() { return getToken(SqlBaseParser.TERMINATED, 0); }
		public TerminalNode BY() { return getToken(SqlBaseParser.BY, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public DelimiterClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delimiterClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterDelimiterClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitDelimiterClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitDelimiterClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DelimiterClauseContext delimiterClause() throws RecognitionException {
		DelimiterClauseContext _localctx = new DelimiterClauseContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_delimiterClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			match(TERMINATED);
			setState(604);
			match(BY);
			setState(605);
			((DelimiterClauseContext)_localctx).delimiter = match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EscapeClauseContext extends ParserRuleContext {
		public Token escaping;
		public TerminalNode ESCAPED() { return getToken(SqlBaseParser.ESCAPED, 0); }
		public TerminalNode BY() { return getToken(SqlBaseParser.BY, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public EscapeClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escapeClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterEscapeClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitEscapeClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitEscapeClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EscapeClauseContext escapeClause() throws RecognitionException {
		EscapeClauseContext _localctx = new EscapeClauseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_escapeClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			match(ESCAPED);
			setState(608);
			match(BY);
			setState(609);
			((EscapeClauseContext)_localctx).escaping = match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationContext extends ParserRuleContext {
		public AliasedRelationContext aliasedRelation() {
			return getRuleContext(AliasedRelationContext.class,0);
		}
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_relation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611);
			aliasedRelation();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinTypeContext extends ParserRuleContext {
		public TerminalNode INNER() { return getToken(SqlBaseParser.INNER, 0); }
		public TerminalNode LEFT() { return getToken(SqlBaseParser.LEFT, 0); }
		public TerminalNode OUTER() { return getToken(SqlBaseParser.OUTER, 0); }
		public TerminalNode RIGHT() { return getToken(SqlBaseParser.RIGHT, 0); }
		public TerminalNode FULL() { return getToken(SqlBaseParser.FULL, 0); }
		public JoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterJoinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitJoinType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitJoinType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinTypeContext joinType() throws RecognitionException {
		JoinTypeContext _localctx = new JoinTypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_joinType);
		int _la;
		try {
			setState(628);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(614);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INNER) {
					{
					setState(613);
					match(INNER);
					}
				}

				}
				break;
			case LEFT:
				enterOuterAlt(_localctx, 2);
				{
				setState(616);
				match(LEFT);
				setState(618);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(617);
					match(OUTER);
					}
				}

				}
				break;
			case RIGHT:
				enterOuterAlt(_localctx, 3);
				{
				setState(620);
				match(RIGHT);
				setState(622);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(621);
					match(OUTER);
					}
				}

				}
				break;
			case FULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(624);
				match(FULL);
				setState(626);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(625);
					match(OUTER);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinCriteriaContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SqlBaseParser.ON, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public TerminalNode USING() { return getToken(SqlBaseParser.USING, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public JoinCriteriaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinCriteria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterJoinCriteria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitJoinCriteria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitJoinCriteria(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinCriteriaContext joinCriteria() throws RecognitionException {
		JoinCriteriaContext _localctx = new JoinCriteriaContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_joinCriteria);
		int _la;
		try {
			setState(644);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(630);
				match(ON);
				setState(631);
				booleanExpression(0);
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(632);
				match(USING);
				setState(633);
				match(T__0);
				setState(634);
				identifier();
				setState(639);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(635);
					match(T__1);
					setState(636);
					identifier();
					}
					}
					setState(641);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(642);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AliasedRelationContext extends ParserRuleContext {
		public RelationPrimaryContext relationPrimary() {
			return getRuleContext(RelationPrimaryContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlBaseParser.AS, 0); }
		public ColumnAliasesContext columnAliases() {
			return getRuleContext(ColumnAliasesContext.class,0);
		}
		public AliasedRelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliasedRelation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterAliasedRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitAliasedRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitAliasedRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AliasedRelationContext aliasedRelation() throws RecognitionException {
		AliasedRelationContext _localctx = new AliasedRelationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_aliasedRelation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(646);
			relationPrimary();
			setState(657);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				{
				setState(648);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(647);
					match(AS);
					}
				}

				setState(650);
				identifier();
				setState(655);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(651);
					match(T__0);
					setState(652);
					columnAliases();
					setState(653);
					match(T__2);
					}
				}

				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnAliasesContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public ColumnAliasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnAliases; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterColumnAliases(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitColumnAliases(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitColumnAliases(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnAliasesContext columnAliases() throws RecognitionException {
		ColumnAliasesContext _localctx = new ColumnAliasesContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_columnAliases);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(659);
			identifier();
			setState(664);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(660);
					match(T__1);
					setState(661);
					identifier();
					}
					} 
				}
				setState(666);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationPrimaryContext extends ParserRuleContext {
		public RelationPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationPrimary; }
	 
		public RelationPrimaryContext() { }
		public void copyFrom(RelationPrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubqueryRelationContext extends RelationPrimaryContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public SubqueryRelationContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSubqueryRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSubqueryRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSubqueryRelation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedRelationContext extends RelationPrimaryContext {
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public ParenthesizedRelationContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterParenthesizedRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitParenthesizedRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitParenthesizedRelation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TableNameContext extends RelationPrimaryContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TableNameContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationPrimaryContext relationPrimary() throws RecognitionException {
		RelationPrimaryContext _localctx = new RelationPrimaryContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_relationPrimary);
		try {
			setState(676);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				_localctx = new TableNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(667);
				qualifiedName();
				}
				break;
			case 2:
				_localctx = new SubqueryRelationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(668);
				match(T__0);
				setState(669);
				query();
				setState(670);
				match(T__2);
				}
				break;
			case 3:
				_localctx = new ParenthesizedRelationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(672);
				match(T__0);
				setState(673);
				relation();
				setState(674);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(678);
			booleanExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanExpressionContext extends ParserRuleContext {
		public BooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpression; }
	 
		public BooleanExpressionContext() { }
		public void copyFrom(BooleanExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicalNotContext extends BooleanExpressionContext {
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public LogicalNotContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterLogicalNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitLogicalNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitLogicalNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanDefaultContext extends BooleanExpressionContext {
		public PredicatedContext predicated() {
			return getRuleContext(PredicatedContext.class,0);
		}
		public BooleanDefaultContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterBooleanDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitBooleanDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitBooleanDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalBinaryContext extends BooleanExpressionContext {
		public BooleanExpressionContext left;
		public Token operator;
		public BooleanExpressionContext right;
		public List<BooleanExpressionContext> booleanExpression() {
			return getRuleContexts(BooleanExpressionContext.class);
		}
		public BooleanExpressionContext booleanExpression(int i) {
			return getRuleContext(BooleanExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(SqlBaseParser.AND, 0); }
		public TerminalNode OR() { return getToken(SqlBaseParser.OR, 0); }
		public LogicalBinaryContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterLogicalBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitLogicalBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitLogicalBinary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		return booleanExpression(0);
	}

	private BooleanExpressionContext booleanExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, _parentState);
		BooleanExpressionContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_booleanExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(684);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case ADD:
			case ALL:
			case ANALYZE:
			case ANY:
			case ARRAY:
			case ASC:
			case AT:
			case BERNOULLI:
			case CALL:
			case CASCADE:
			case CATALOGS:
			case COALESCE:
			case COLUMN:
			case COLUMNS:
			case COMMENT:
			case COMMIT:
			case COMMITTED:
			case CURRENT:
			case DATA:
			case DATE:
			case DAY:
			case DESC:
			case DISTRIBUTED:
			case EXCLUDING:
			case EXISTS:
			case EXPLAIN:
			case FALSE:
			case FILTER:
			case FIRST:
			case FOLLOWING:
			case FORMAT:
			case FUNCTIONS:
			case GRANT:
			case GRANTS:
			case GRAPHVIZ:
			case HOUR:
			case IF:
			case INCLUDING:
			case INPUT:
			case INTEGER:
			case INTERVAL:
			case ISOLATION:
			case LAST:
			case LATERAL:
			case LEVEL:
			case LIMIT:
			case LOGICAL:
			case MAP:
			case MINUTE:
			case MONTH:
			case NFC:
			case NFD:
			case NFKC:
			case NFKD:
			case NO:
			case NULL:
			case NULLIF:
			case NULLS:
			case ONLY:
			case OPTION:
			case ORDINALITY:
			case OUTPUT:
			case OVER:
			case PARTITION:
			case PARTITIONS:
			case POSITION:
			case PRECEDING:
			case PRIVILEGES:
			case PROPERTIES:
			case PUBLIC:
			case RANGE:
			case READ:
			case RENAME:
			case REPEATABLE:
			case REPLACE:
			case RESET:
			case RESTRICT:
			case REVOKE:
			case ROLLBACK:
			case ROW:
			case ROWS:
			case SCHEMA:
			case SCHEMAS:
			case SECOND:
			case SESSION:
			case SET:
			case SETS:
			case SHOW:
			case SMALLINT:
			case SOME:
			case START:
			case STATS:
			case SUBSTRING:
			case SYSTEM:
			case TABLES:
			case TABLESAMPLE:
			case TEXT:
			case TIME:
			case TIMESTAMP:
			case TINYINT:
			case TO:
			case TRUE:
			case TRY_CAST:
			case TYPE:
			case UNBOUNDED:
			case UNCOMMITTED:
			case USE:
			case VALIDATE:
			case VERBOSE:
			case VIEW:
			case WORK:
			case WRITE:
			case YEAR:
			case ZONE:
			case PLUS:
			case MINUS:
			case STRING:
			case UNICODE_STRING:
			case BINARY_LITERAL:
			case INTEGER_VALUE:
			case DECIMAL_VALUE:
			case IDENTIFIER:
			case DIGIT_IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
			case DOUBLE_PRECISION:
				{
				_localctx = new BooleanDefaultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(681);
				predicated();
				}
				break;
			case NOT:
				{
				_localctx = new LogicalNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(682);
				match(NOT);
				setState(683);
				booleanExpression(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(694);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(692);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalBinaryContext(new BooleanExpressionContext(_parentctx, _parentState));
						((LogicalBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(686);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(687);
						((LogicalBinaryContext)_localctx).operator = match(AND);
						setState(688);
						((LogicalBinaryContext)_localctx).right = booleanExpression(3);
						}
						break;
					case 2:
						{
						_localctx = new LogicalBinaryContext(new BooleanExpressionContext(_parentctx, _parentState));
						((LogicalBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(689);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(690);
						((LogicalBinaryContext)_localctx).operator = match(OR);
						setState(691);
						((LogicalBinaryContext)_localctx).right = booleanExpression(2);
						}
						break;
					}
					} 
				}
				setState(696);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PredicatedContext extends ParserRuleContext {
		public ValueExpressionContext valueExpression;
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public PredicatedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicated; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterPredicated(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitPredicated(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitPredicated(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatedContext predicated() throws RecognitionException {
		PredicatedContext _localctx = new PredicatedContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_predicated);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697);
			((PredicatedContext)_localctx).valueExpression = valueExpression(0);
			setState(699);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				{
				setState(698);
				predicate(((PredicatedContext)_localctx).valueExpression);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public ParserRuleContext value;
		public PredicateContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PredicateContext(ParserRuleContext parent, int invokingState, ParserRuleContext value) {
			super(parent, invokingState);
			this.value = value;
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
	 
		public PredicateContext() { }
		public void copyFrom(PredicateContext ctx) {
			super.copyFrom(ctx);
			this.value = ctx.value;
		}
	}
	public static class ComparisonContext extends PredicateContext {
		public ValueExpressionContext right;
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public ComparisonContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LikeContext extends PredicateContext {
		public ValueExpressionContext pattern;
		public ValueExpressionContext escape;
		public TerminalNode LIKE() { return getToken(SqlBaseParser.LIKE, 0); }
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public TerminalNode ESCAPE() { return getToken(SqlBaseParser.ESCAPE, 0); }
		public LikeContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterLike(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitLike(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitLike(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InSubqueryContext extends PredicateContext {
		public TerminalNode IN() { return getToken(SqlBaseParser.IN, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public InSubqueryContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterInSubquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitInSubquery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitInSubquery(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DistinctFromContext extends PredicateContext {
		public ValueExpressionContext right;
		public TerminalNode IS() { return getToken(SqlBaseParser.IS, 0); }
		public TerminalNode DISTINCT() { return getToken(SqlBaseParser.DISTINCT, 0); }
		public TerminalNode FROM() { return getToken(SqlBaseParser.FROM, 0); }
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public DistinctFromContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterDistinctFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitDistinctFrom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitDistinctFrom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InListContext extends PredicateContext {
		public TerminalNode IN() { return getToken(SqlBaseParser.IN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public InListContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterInList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitInList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitInList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullPredicateContext extends PredicateContext {
		public TerminalNode IS() { return getToken(SqlBaseParser.IS, 0); }
		public TerminalNode NULL() { return getToken(SqlBaseParser.NULL, 0); }
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public NullPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterNullPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitNullPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitNullPredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BetweenContext extends PredicateContext {
		public ValueExpressionContext lower;
		public ValueExpressionContext upper;
		public TerminalNode BETWEEN() { return getToken(SqlBaseParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(SqlBaseParser.AND, 0); }
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(SqlBaseParser.NOT, 0); }
		public BetweenContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterBetween(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitBetween(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitBetween(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuantifiedComparisonContext extends PredicateContext {
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ComparisonQuantifierContext comparisonQuantifier() {
			return getRuleContext(ComparisonQuantifierContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public QuantifiedComparisonContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterQuantifiedComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitQuantifiedComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitQuantifiedComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate(ParserRuleContext value) throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState(), value);
		enterRule(_localctx, 60, RULE_predicate);
		int _la;
		try {
			setState(762);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
			case 1:
				_localctx = new ComparisonContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(701);
				comparisonOperator();
				setState(702);
				((ComparisonContext)_localctx).right = valueExpression(0);
				}
				break;
			case 2:
				_localctx = new QuantifiedComparisonContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(704);
				comparisonOperator();
				setState(705);
				comparisonQuantifier();
				setState(706);
				match(T__0);
				setState(707);
				query();
				setState(708);
				match(T__2);
				}
				break;
			case 3:
				_localctx = new BetweenContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(711);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(710);
					match(NOT);
					}
				}

				setState(713);
				match(BETWEEN);
				setState(714);
				((BetweenContext)_localctx).lower = valueExpression(0);
				setState(715);
				match(AND);
				setState(716);
				((BetweenContext)_localctx).upper = valueExpression(0);
				}
				break;
			case 4:
				_localctx = new InListContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(719);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(718);
					match(NOT);
					}
				}

				setState(721);
				match(IN);
				setState(722);
				match(T__0);
				setState(723);
				expression();
				setState(728);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(724);
					match(T__1);
					setState(725);
					expression();
					}
					}
					setState(730);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(731);
				match(T__2);
				}
				break;
			case 5:
				_localctx = new InSubqueryContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(734);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(733);
					match(NOT);
					}
				}

				setState(736);
				match(IN);
				setState(737);
				match(T__0);
				setState(738);
				query();
				setState(739);
				match(T__2);
				}
				break;
			case 6:
				_localctx = new LikeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(742);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(741);
					match(NOT);
					}
				}

				setState(744);
				match(LIKE);
				setState(745);
				((LikeContext)_localctx).pattern = valueExpression(0);
				setState(748);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
				case 1:
					{
					setState(746);
					match(ESCAPE);
					setState(747);
					((LikeContext)_localctx).escape = valueExpression(0);
					}
					break;
				}
				}
				break;
			case 7:
				_localctx = new NullPredicateContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(750);
				match(IS);
				setState(752);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(751);
					match(NOT);
					}
				}

				setState(754);
				match(NULL);
				}
				break;
			case 8:
				_localctx = new DistinctFromContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(755);
				match(IS);
				setState(757);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(756);
					match(NOT);
					}
				}

				setState(759);
				match(DISTINCT);
				setState(760);
				match(FROM);
				setState(761);
				((DistinctFromContext)_localctx).right = valueExpression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueExpressionContext extends ParserRuleContext {
		public ValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueExpression; }
	 
		public ValueExpressionContext() { }
		public void copyFrom(ValueExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueExpressionDefaultContext extends ValueExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public ValueExpressionDefaultContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterValueExpressionDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitValueExpressionDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitValueExpressionDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConcatenationContext extends ValueExpressionContext {
		public ValueExpressionContext left;
		public ValueExpressionContext right;
		public TerminalNode CONCAT() { return getToken(SqlBaseParser.CONCAT, 0); }
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public ConcatenationContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterConcatenation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitConcatenation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitConcatenation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticBinaryContext extends ValueExpressionContext {
		public ValueExpressionContext left;
		public Token operator;
		public ValueExpressionContext right;
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode ASTERISK() { return getToken(SqlBaseParser.ASTERISK, 0); }
		public TerminalNode SLASH() { return getToken(SqlBaseParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(SqlBaseParser.PERCENT, 0); }
		public TerminalNode PLUS() { return getToken(SqlBaseParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SqlBaseParser.MINUS, 0); }
		public ArithmeticBinaryContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterArithmeticBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitArithmeticBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitArithmeticBinary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticUnaryContext extends ValueExpressionContext {
		public Token operator;
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(SqlBaseParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SqlBaseParser.PLUS, 0); }
		public ArithmeticUnaryContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterArithmeticUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitArithmeticUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitArithmeticUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueExpressionContext valueExpression() throws RecognitionException {
		return valueExpression(0);
	}

	private ValueExpressionContext valueExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValueExpressionContext _localctx = new ValueExpressionContext(_ctx, _parentState);
		ValueExpressionContext _prevctx = _localctx;
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_valueExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(768);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case ADD:
			case ALL:
			case ANALYZE:
			case ANY:
			case ARRAY:
			case ASC:
			case AT:
			case BERNOULLI:
			case CALL:
			case CASCADE:
			case CATALOGS:
			case COALESCE:
			case COLUMN:
			case COLUMNS:
			case COMMENT:
			case COMMIT:
			case COMMITTED:
			case CURRENT:
			case DATA:
			case DATE:
			case DAY:
			case DESC:
			case DISTRIBUTED:
			case EXCLUDING:
			case EXISTS:
			case EXPLAIN:
			case FALSE:
			case FILTER:
			case FIRST:
			case FOLLOWING:
			case FORMAT:
			case FUNCTIONS:
			case GRANT:
			case GRANTS:
			case GRAPHVIZ:
			case HOUR:
			case IF:
			case INCLUDING:
			case INPUT:
			case INTEGER:
			case INTERVAL:
			case ISOLATION:
			case LAST:
			case LATERAL:
			case LEVEL:
			case LIMIT:
			case LOGICAL:
			case MAP:
			case MINUTE:
			case MONTH:
			case NFC:
			case NFD:
			case NFKC:
			case NFKD:
			case NO:
			case NULL:
			case NULLIF:
			case NULLS:
			case ONLY:
			case OPTION:
			case ORDINALITY:
			case OUTPUT:
			case OVER:
			case PARTITION:
			case PARTITIONS:
			case POSITION:
			case PRECEDING:
			case PRIVILEGES:
			case PROPERTIES:
			case PUBLIC:
			case RANGE:
			case READ:
			case RENAME:
			case REPEATABLE:
			case REPLACE:
			case RESET:
			case RESTRICT:
			case REVOKE:
			case ROLLBACK:
			case ROW:
			case ROWS:
			case SCHEMA:
			case SCHEMAS:
			case SECOND:
			case SESSION:
			case SET:
			case SETS:
			case SHOW:
			case SMALLINT:
			case SOME:
			case START:
			case STATS:
			case SUBSTRING:
			case SYSTEM:
			case TABLES:
			case TABLESAMPLE:
			case TEXT:
			case TIME:
			case TIMESTAMP:
			case TINYINT:
			case TO:
			case TRUE:
			case TRY_CAST:
			case TYPE:
			case UNBOUNDED:
			case UNCOMMITTED:
			case USE:
			case VALIDATE:
			case VERBOSE:
			case VIEW:
			case WORK:
			case WRITE:
			case YEAR:
			case ZONE:
			case STRING:
			case UNICODE_STRING:
			case BINARY_LITERAL:
			case INTEGER_VALUE:
			case DECIMAL_VALUE:
			case IDENTIFIER:
			case DIGIT_IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
			case DOUBLE_PRECISION:
				{
				_localctx = new ValueExpressionDefaultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(765);
				primaryExpression(0);
				}
				break;
			case PLUS:
			case MINUS:
				{
				_localctx = new ArithmeticUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(766);
				((ArithmeticUnaryContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((ArithmeticUnaryContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(767);
				valueExpression(4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(781);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(779);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(770);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(771);
						((ArithmeticBinaryContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 206)) & ~0x3f) == 0 && ((1L << (_la - 206)) & ((1L << (ASTERISK - 206)) | (1L << (SLASH - 206)) | (1L << (PERCENT - 206)))) != 0)) ) {
							((ArithmeticBinaryContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(772);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(4);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(773);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(774);
						((ArithmeticBinaryContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ArithmeticBinaryContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(775);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(3);
						}
						break;
					case 3:
						{
						_localctx = new ConcatenationContext(new ValueExpressionContext(_parentctx, _parentState));
						((ConcatenationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(776);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(777);
						match(CONCAT);
						setState(778);
						((ConcatenationContext)_localctx).right = valueExpression(2);
						}
						break;
					}
					} 
				}
				setState(783);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	 
		public PrimaryExpressionContext() { }
		public void copyFrom(PrimaryExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BinaryLiteralContext extends PrimaryExpressionContext {
		public TerminalNode BINARY_LITERAL() { return getToken(SqlBaseParser.BINARY_LITERAL, 0); }
		public BinaryLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterBinaryLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitBinaryLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitBinaryLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DereferenceContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext base;
		public IdentifierContext fieldName;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DereferenceContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterDereference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitDereference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitDereference(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColumnReferenceContext extends PrimaryExpressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ColumnReferenceContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterColumnReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitColumnReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitColumnReference(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullLiteralContext extends PrimaryExpressionContext {
		public TerminalNode NULL() { return getToken(SqlBaseParser.NULL, 0); }
		public NullLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterNullLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitNullLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitNullLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedExpressionContext extends PrimaryExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesizedExpressionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterParenthesizedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitParenthesizedExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitParenthesizedExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralContext extends PrimaryExpressionContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public StringLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeConstructorContext extends PrimaryExpressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode DOUBLE_PRECISION() { return getToken(SqlBaseParser.DOUBLE_PRECISION, 0); }
		public TypeConstructorContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterTypeConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitTypeConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitTypeConstructor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallContext extends PrimaryExpressionContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode ASTERISK() { return getToken(SqlBaseParser.ASTERISK, 0); }
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public FunctionCallContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExistsContext extends PrimaryExpressionContext {
		public TerminalNode EXISTS() { return getToken(SqlBaseParser.EXISTS, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public ExistsContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterExists(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitExists(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitExists(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubqueryExpressionContext extends PrimaryExpressionContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public SubqueryExpressionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterSubqueryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitSubqueryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitSubqueryExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumericLiteralContext extends PrimaryExpressionContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumericLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterNumericLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitNumericLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitNumericLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanLiteralContext extends PrimaryExpressionContext {
		public BooleanValueContext booleanValue() {
			return getRuleContext(BooleanValueContext.class,0);
		}
		public BooleanLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		return primaryExpression(0);
	}

	private PrimaryExpressionContext primaryExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, _parentState);
		PrimaryExpressionContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_primaryExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(835);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
			case 1:
				{
				_localctx = new NullLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(785);
				match(NULL);
				}
				break;
			case 2:
				{
				_localctx = new TypeConstructorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(786);
				identifier();
				setState(787);
				string();
				}
				break;
			case 3:
				{
				_localctx = new TypeConstructorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(789);
				match(DOUBLE_PRECISION);
				setState(790);
				string();
				}
				break;
			case 4:
				{
				_localctx = new NumericLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(791);
				number();
				}
				break;
			case 5:
				{
				_localctx = new BooleanLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(792);
				booleanValue();
				}
				break;
			case 6:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(793);
				string();
				}
				break;
			case 7:
				{
				_localctx = new BinaryLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(794);
				match(BINARY_LITERAL);
				}
				break;
			case 8:
				{
				_localctx = new FunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(795);
				qualifiedName();
				setState(796);
				match(T__0);
				setState(797);
				match(ASTERISK);
				setState(798);
				match(T__2);
				setState(800);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
				case 1:
					{
					setState(799);
					filter();
					}
					break;
				}
				}
				break;
			case 9:
				{
				_localctx = new FunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(802);
				qualifiedName();
				setState(803);
				match(T__0);
				setState(815);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << ADD) | (1L << ALL) | (1L << ANALYZE) | (1L << ANY) | (1L << ARRAY) | (1L << ASC) | (1L << AT) | (1L << BERNOULLI) | (1L << CALL) | (1L << CASCADE) | (1L << CATALOGS) | (1L << COALESCE) | (1L << COLUMN) | (1L << COLUMNS) | (1L << COMMENT) | (1L << COMMIT) | (1L << COMMITTED) | (1L << CURRENT) | (1L << DATA) | (1L << DATE) | (1L << DAY) | (1L << DESC) | (1L << DISTINCT) | (1L << DISTRIBUTED) | (1L << EXCLUDING) | (1L << EXISTS) | (1L << EXPLAIN) | (1L << FALSE) | (1L << FILTER))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (FIRST - 64)) | (1L << (FOLLOWING - 64)) | (1L << (FORMAT - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (GRANT - 64)) | (1L << (GRANTS - 64)) | (1L << (GRAPHVIZ - 64)) | (1L << (HOUR - 64)) | (1L << (IF - 64)) | (1L << (INCLUDING - 64)) | (1L << (INPUT - 64)) | (1L << (INTEGER - 64)) | (1L << (INTERVAL - 64)) | (1L << (ISOLATION - 64)) | (1L << (LAST - 64)) | (1L << (LATERAL - 64)) | (1L << (LEVEL - 64)) | (1L << (LIMIT - 64)) | (1L << (LOGICAL - 64)) | (1L << (MAP - 64)) | (1L << (MINUTE - 64)) | (1L << (MONTH - 64)) | (1L << (NFC - 64)) | (1L << (NFD - 64)) | (1L << (NFKC - 64)) | (1L << (NFKD - 64)) | (1L << (NO - 64)) | (1L << (NOT - 64)) | (1L << (NULL - 64)) | (1L << (NULLIF - 64)) | (1L << (NULLS - 64)) | (1L << (ONLY - 64)) | (1L << (OPTION - 64)) | (1L << (ORDINALITY - 64)) | (1L << (OUTPUT - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (PARTITIONS - 128)) | (1L << (POSITION - 128)) | (1L << (PRECEDING - 128)) | (1L << (PRIVILEGES - 128)) | (1L << (PROPERTIES - 128)) | (1L << (PUBLIC - 128)) | (1L << (RANGE - 128)) | (1L << (READ - 128)) | (1L << (RENAME - 128)) | (1L << (REPEATABLE - 128)) | (1L << (REPLACE - 128)) | (1L << (RESET - 128)) | (1L << (RESTRICT - 128)) | (1L << (REVOKE - 128)) | (1L << (ROLLBACK - 128)) | (1L << (ROW - 128)) | (1L << (ROWS - 128)) | (1L << (SCHEMA - 128)) | (1L << (SCHEMAS - 128)) | (1L << (SECOND - 128)) | (1L << (SESSION - 128)) | (1L << (SET - 128)) | (1L << (SETS - 128)) | (1L << (SHOW - 128)) | (1L << (SMALLINT - 128)) | (1L << (SOME - 128)) | (1L << (START - 128)) | (1L << (STATS - 128)) | (1L << (SUBSTRING - 128)) | (1L << (SYSTEM - 128)) | (1L << (TABLES - 128)) | (1L << (TABLESAMPLE - 128)) | (1L << (TEXT - 128)) | (1L << (TIME - 128)) | (1L << (TIMESTAMP - 128)) | (1L << (TINYINT - 128)) | (1L << (TO - 128)) | (1L << (TRUE - 128)) | (1L << (TRY_CAST - 128)) | (1L << (TYPE - 128)) | (1L << (UNBOUNDED - 128)) | (1L << (UNCOMMITTED - 128)) | (1L << (USE - 128)) | (1L << (VALIDATE - 128)) | (1L << (VERBOSE - 128)) | (1L << (VIEW - 128)))) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & ((1L << (WORK - 194)) | (1L << (WRITE - 194)) | (1L << (YEAR - 194)) | (1L << (ZONE - 194)) | (1L << (PLUS - 194)) | (1L << (MINUS - 194)) | (1L << (STRING - 194)) | (1L << (UNICODE_STRING - 194)) | (1L << (BINARY_LITERAL - 194)) | (1L << (INTEGER_VALUE - 194)) | (1L << (DECIMAL_VALUE - 194)) | (1L << (IDENTIFIER - 194)) | (1L << (DIGIT_IDENTIFIER - 194)) | (1L << (BACKQUOTED_IDENTIFIER - 194)) | (1L << (DOUBLE_PRECISION - 194)))) != 0)) {
					{
					setState(805);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
					case 1:
						{
						setState(804);
						setQuantifier();
						}
						break;
					}
					setState(807);
					expression();
					setState(812);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(808);
						match(T__1);
						setState(809);
						expression();
						}
						}
						setState(814);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(817);
				match(T__2);
				setState(819);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
				case 1:
					{
					setState(818);
					filter();
					}
					break;
				}
				}
				break;
			case 10:
				{
				_localctx = new SubqueryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(821);
				match(T__0);
				setState(822);
				query();
				setState(823);
				match(T__2);
				}
				break;
			case 11:
				{
				_localctx = new ExistsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(825);
				match(EXISTS);
				setState(826);
				match(T__0);
				setState(827);
				query();
				setState(828);
				match(T__2);
				}
				break;
			case 12:
				{
				_localctx = new ColumnReferenceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(830);
				identifier();
				}
				break;
			case 13:
				{
				_localctx = new ParenthesizedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(831);
				match(T__0);
				setState(832);
				expression();
				setState(833);
				match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(842);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DereferenceContext(new PrimaryExpressionContext(_parentctx, _parentState));
					((DereferenceContext)_localctx).base = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
					setState(837);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(838);
					match(T__3);
					setState(839);
					((DereferenceContext)_localctx).fieldName = identifier();
					}
					} 
				}
				setState(844);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
	 
		public StringContext() { }
		public void copyFrom(StringContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnicodeStringLiteralContext extends StringContext {
		public TerminalNode UNICODE_STRING() { return getToken(SqlBaseParser.UNICODE_STRING, 0); }
		public TerminalNode UESCAPE() { return getToken(SqlBaseParser.UESCAPE, 0); }
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public UnicodeStringLiteralContext(StringContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterUnicodeStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitUnicodeStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitUnicodeStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BasicStringLiteralContext extends StringContext {
		public TerminalNode STRING() { return getToken(SqlBaseParser.STRING, 0); }
		public BasicStringLiteralContext(StringContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterBasicStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitBasicStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitBasicStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_string);
		try {
			setState(851);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new BasicStringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(845);
				match(STRING);
				}
				break;
			case UNICODE_STRING:
				_localctx = new UnicodeStringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(846);
				match(UNICODE_STRING);
				setState(849);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
				case 1:
					{
					setState(847);
					match(UESCAPE);
					setState(848);
					match(STRING);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(SqlBaseParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(SqlBaseParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(SqlBaseParser.LT, 0); }
		public TerminalNode LTE() { return getToken(SqlBaseParser.LTE, 0); }
		public TerminalNode GT() { return getToken(SqlBaseParser.GT, 0); }
		public TerminalNode GTE() { return getToken(SqlBaseParser.GTE, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitComparisonOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitComparisonOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(853);
			_la = _input.LA(1);
			if ( !(((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (EQ - 198)) | (1L << (NEQ - 198)) | (1L << (LT - 198)) | (1L << (LTE - 198)) | (1L << (GT - 198)) | (1L << (GTE - 198)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonQuantifierContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(SqlBaseParser.ALL, 0); }
		public TerminalNode SOME() { return getToken(SqlBaseParser.SOME, 0); }
		public TerminalNode ANY() { return getToken(SqlBaseParser.ANY, 0); }
		public ComparisonQuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonQuantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterComparisonQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitComparisonQuantifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitComparisonQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonQuantifierContext comparisonQuantifier() throws RecognitionException {
		ComparisonQuantifierContext _localctx = new ComparisonQuantifierContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_comparisonQuantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(855);
			_la = _input.LA(1);
			if ( !(_la==ALL || _la==ANY || _la==SOME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanValueContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SqlBaseParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SqlBaseParser.FALSE, 0); }
		public BooleanValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterBooleanValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitBooleanValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitBooleanValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanValueContext booleanValue() throws RecognitionException {
		BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_booleanValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(857);
			_la = _input.LA(1);
			if ( !(_la==FALSE || _la==TRUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ARRAY() { return getToken(SqlBaseParser.ARRAY, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode MAP() { return getToken(SqlBaseParser.MAP, 0); }
		public TerminalNode ROW() { return getToken(SqlBaseParser.ROW, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public List<TypeParameterContext> typeParameter() {
			return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
			return getRuleContext(TypeParameterContext.class,i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 74;
		enterRecursionRule(_localctx, 74, RULE_type, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(901);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,141,_ctx) ) {
			case 1:
				{
				setState(860);
				match(ARRAY);
				setState(861);
				match(LT);
				setState(862);
				type(0);
				setState(863);
				match(GT);
				}
				break;
			case 2:
				{
				setState(865);
				match(MAP);
				setState(866);
				match(LT);
				setState(867);
				type(0);
				setState(868);
				match(T__1);
				setState(869);
				type(0);
				setState(870);
				match(GT);
				}
				break;
			case 3:
				{
				setState(872);
				match(ROW);
				setState(873);
				match(T__0);
				setState(874);
				identifier();
				setState(875);
				type(0);
				setState(882);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(876);
					match(T__1);
					setState(877);
					identifier();
					setState(878);
					type(0);
					}
					}
					setState(884);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(885);
				match(T__2);
				}
				break;
			case 4:
				{
				setState(887);
				baseType();
				setState(899);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
				case 1:
					{
					setState(888);
					match(T__0);
					setState(889);
					typeParameter();
					setState(894);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(890);
						match(T__1);
						setState(891);
						typeParameter();
						}
						}
						setState(896);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(897);
					match(T__2);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(907);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(903);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(904);
					match(ARRAY);
					}
					} 
				}
				setState(909);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeParameterContext extends ParserRuleContext {
		public TerminalNode INTEGER_VALUE() { return getToken(SqlBaseParser.INTEGER_VALUE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitTypeParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitTypeParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_typeParameter);
		try {
			setState(912);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER_VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(910);
				match(INTEGER_VALUE);
				}
				break;
			case ADD:
			case ALL:
			case ANALYZE:
			case ANY:
			case ARRAY:
			case ASC:
			case AT:
			case BERNOULLI:
			case CALL:
			case CASCADE:
			case CATALOGS:
			case COALESCE:
			case COLUMN:
			case COLUMNS:
			case COMMENT:
			case COMMIT:
			case COMMITTED:
			case CURRENT:
			case DATA:
			case DATE:
			case DAY:
			case DESC:
			case DISTRIBUTED:
			case EXCLUDING:
			case EXPLAIN:
			case FILTER:
			case FIRST:
			case FOLLOWING:
			case FORMAT:
			case FUNCTIONS:
			case GRANT:
			case GRANTS:
			case GRAPHVIZ:
			case HOUR:
			case IF:
			case INCLUDING:
			case INPUT:
			case INTEGER:
			case INTERVAL:
			case ISOLATION:
			case LAST:
			case LATERAL:
			case LEVEL:
			case LIMIT:
			case LOGICAL:
			case MAP:
			case MINUTE:
			case MONTH:
			case NFC:
			case NFD:
			case NFKC:
			case NFKD:
			case NO:
			case NULLIF:
			case NULLS:
			case ONLY:
			case OPTION:
			case ORDINALITY:
			case OUTPUT:
			case OVER:
			case PARTITION:
			case PARTITIONS:
			case POSITION:
			case PRECEDING:
			case PRIVILEGES:
			case PROPERTIES:
			case PUBLIC:
			case RANGE:
			case READ:
			case RENAME:
			case REPEATABLE:
			case REPLACE:
			case RESET:
			case RESTRICT:
			case REVOKE:
			case ROLLBACK:
			case ROW:
			case ROWS:
			case SCHEMA:
			case SCHEMAS:
			case SECOND:
			case SESSION:
			case SET:
			case SETS:
			case SHOW:
			case SMALLINT:
			case SOME:
			case START:
			case STATS:
			case SUBSTRING:
			case SYSTEM:
			case TABLES:
			case TABLESAMPLE:
			case TEXT:
			case TIME:
			case TIMESTAMP:
			case TINYINT:
			case TO:
			case TRY_CAST:
			case TYPE:
			case UNBOUNDED:
			case UNCOMMITTED:
			case USE:
			case VALIDATE:
			case VERBOSE:
			case VIEW:
			case WORK:
			case WRITE:
			case YEAR:
			case ZONE:
			case IDENTIFIER:
			case DIGIT_IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
			case TIME_WITH_TIME_ZONE:
			case TIMESTAMP_WITH_TIME_ZONE:
			case DOUBLE_PRECISION:
				enterOuterAlt(_localctx, 2);
				{
				setState(911);
				type(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BaseTypeContext extends ParserRuleContext {
		public TerminalNode TIME_WITH_TIME_ZONE() { return getToken(SqlBaseParser.TIME_WITH_TIME_ZONE, 0); }
		public TerminalNode TIMESTAMP_WITH_TIME_ZONE() { return getToken(SqlBaseParser.TIMESTAMP_WITH_TIME_ZONE, 0); }
		public TerminalNode DOUBLE_PRECISION() { return getToken(SqlBaseParser.DOUBLE_PRECISION, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterBaseType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitBaseType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitBaseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_baseType);
		try {
			setState(918);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TIME_WITH_TIME_ZONE:
				enterOuterAlt(_localctx, 1);
				{
				setState(914);
				match(TIME_WITH_TIME_ZONE);
				}
				break;
			case TIMESTAMP_WITH_TIME_ZONE:
				enterOuterAlt(_localctx, 2);
				{
				setState(915);
				match(TIMESTAMP_WITH_TIME_ZONE);
				}
				break;
			case DOUBLE_PRECISION:
				enterOuterAlt(_localctx, 3);
				{
				setState(916);
				match(DOUBLE_PRECISION);
				}
				break;
			case ADD:
			case ALL:
			case ANALYZE:
			case ANY:
			case ARRAY:
			case ASC:
			case AT:
			case BERNOULLI:
			case CALL:
			case CASCADE:
			case CATALOGS:
			case COALESCE:
			case COLUMN:
			case COLUMNS:
			case COMMENT:
			case COMMIT:
			case COMMITTED:
			case CURRENT:
			case DATA:
			case DATE:
			case DAY:
			case DESC:
			case DISTRIBUTED:
			case EXCLUDING:
			case EXPLAIN:
			case FILTER:
			case FIRST:
			case FOLLOWING:
			case FORMAT:
			case FUNCTIONS:
			case GRANT:
			case GRANTS:
			case GRAPHVIZ:
			case HOUR:
			case IF:
			case INCLUDING:
			case INPUT:
			case INTEGER:
			case INTERVAL:
			case ISOLATION:
			case LAST:
			case LATERAL:
			case LEVEL:
			case LIMIT:
			case LOGICAL:
			case MAP:
			case MINUTE:
			case MONTH:
			case NFC:
			case NFD:
			case NFKC:
			case NFKD:
			case NO:
			case NULLIF:
			case NULLS:
			case ONLY:
			case OPTION:
			case ORDINALITY:
			case OUTPUT:
			case OVER:
			case PARTITION:
			case PARTITIONS:
			case POSITION:
			case PRECEDING:
			case PRIVILEGES:
			case PROPERTIES:
			case PUBLIC:
			case RANGE:
			case READ:
			case RENAME:
			case REPEATABLE:
			case REPLACE:
			case RESET:
			case RESTRICT:
			case REVOKE:
			case ROLLBACK:
			case ROW:
			case ROWS:
			case SCHEMA:
			case SCHEMAS:
			case SECOND:
			case SESSION:
			case SET:
			case SETS:
			case SHOW:
			case SMALLINT:
			case SOME:
			case START:
			case STATS:
			case SUBSTRING:
			case SYSTEM:
			case TABLES:
			case TABLESAMPLE:
			case TEXT:
			case TIME:
			case TIMESTAMP:
			case TINYINT:
			case TO:
			case TRY_CAST:
			case TYPE:
			case UNBOUNDED:
			case UNCOMMITTED:
			case USE:
			case VALIDATE:
			case VERBOSE:
			case VIEW:
			case WORK:
			case WRITE:
			case YEAR:
			case ZONE:
			case IDENTIFIER:
			case DIGIT_IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(917);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhenClauseContext extends ParserRuleContext {
		public ExpressionContext condition;
		public ExpressionContext result;
		public TerminalNode WHEN() { return getToken(SqlBaseParser.WHEN, 0); }
		public TerminalNode THEN() { return getToken(SqlBaseParser.THEN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public WhenClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterWhenClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitWhenClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitWhenClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenClauseContext whenClause() throws RecognitionException {
		WhenClauseContext _localctx = new WhenClauseContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_whenClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(920);
			match(WHEN);
			setState(921);
			((WhenClauseContext)_localctx).condition = expression();
			setState(922);
			match(THEN);
			setState(923);
			((WhenClauseContext)_localctx).result = expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilterContext extends ParserRuleContext {
		public TerminalNode FILTER() { return getToken(SqlBaseParser.FILTER, 0); }
		public TerminalNode WHERE() { return getToken(SqlBaseParser.WHERE, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public FilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterContext filter() throws RecognitionException {
		FilterContext _localctx = new FilterContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_filter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(925);
			match(FILTER);
			setState(926);
			match(T__0);
			setState(927);
			match(WHERE);
			setState(928);
			booleanExpression(0);
			setState(929);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(931);
			identifier();
			setState(936);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,145,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(932);
					match(T__3);
					setState(933);
					identifier();
					}
					} 
				}
				setState(938);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,145,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	 
		public IdentifierContext() { }
		public void copyFrom(IdentifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BackQuotedIdentifierContext extends IdentifierContext {
		public TerminalNode BACKQUOTED_IDENTIFIER() { return getToken(SqlBaseParser.BACKQUOTED_IDENTIFIER, 0); }
		public BackQuotedIdentifierContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterBackQuotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitBackQuotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitBackQuotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DigitIdentifierContext extends IdentifierContext {
		public TerminalNode DIGIT_IDENTIFIER() { return getToken(SqlBaseParser.DIGIT_IDENTIFIER, 0); }
		public DigitIdentifierContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterDigitIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitDigitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitDigitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnquotedIdentifierContext extends IdentifierContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlBaseParser.IDENTIFIER, 0); }
		public NonReservedContext nonReserved() {
			return getRuleContext(NonReservedContext.class,0);
		}
		public UnquotedIdentifierContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterUnquotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitUnquotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitUnquotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_identifier);
		try {
			setState(943);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new UnquotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(939);
				match(IDENTIFIER);
				}
				break;
			case ADD:
			case ALL:
			case ANALYZE:
			case ANY:
			case ARRAY:
			case ASC:
			case AT:
			case BERNOULLI:
			case CALL:
			case CASCADE:
			case CATALOGS:
			case COALESCE:
			case COLUMN:
			case COLUMNS:
			case COMMENT:
			case COMMIT:
			case COMMITTED:
			case CURRENT:
			case DATA:
			case DATE:
			case DAY:
			case DESC:
			case DISTRIBUTED:
			case EXCLUDING:
			case EXPLAIN:
			case FILTER:
			case FIRST:
			case FOLLOWING:
			case FORMAT:
			case FUNCTIONS:
			case GRANT:
			case GRANTS:
			case GRAPHVIZ:
			case HOUR:
			case IF:
			case INCLUDING:
			case INPUT:
			case INTEGER:
			case INTERVAL:
			case ISOLATION:
			case LAST:
			case LATERAL:
			case LEVEL:
			case LIMIT:
			case LOGICAL:
			case MAP:
			case MINUTE:
			case MONTH:
			case NFC:
			case NFD:
			case NFKC:
			case NFKD:
			case NO:
			case NULLIF:
			case NULLS:
			case ONLY:
			case OPTION:
			case ORDINALITY:
			case OUTPUT:
			case OVER:
			case PARTITION:
			case PARTITIONS:
			case POSITION:
			case PRECEDING:
			case PRIVILEGES:
			case PROPERTIES:
			case PUBLIC:
			case RANGE:
			case READ:
			case RENAME:
			case REPEATABLE:
			case REPLACE:
			case RESET:
			case RESTRICT:
			case REVOKE:
			case ROLLBACK:
			case ROW:
			case ROWS:
			case SCHEMA:
			case SCHEMAS:
			case SECOND:
			case SESSION:
			case SET:
			case SETS:
			case SHOW:
			case SMALLINT:
			case SOME:
			case START:
			case STATS:
			case SUBSTRING:
			case SYSTEM:
			case TABLES:
			case TABLESAMPLE:
			case TEXT:
			case TIME:
			case TIMESTAMP:
			case TINYINT:
			case TO:
			case TRY_CAST:
			case TYPE:
			case UNBOUNDED:
			case UNCOMMITTED:
			case USE:
			case VALIDATE:
			case VERBOSE:
			case VIEW:
			case WORK:
			case WRITE:
			case YEAR:
			case ZONE:
				_localctx = new UnquotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(940);
				nonReserved();
				}
				break;
			case BACKQUOTED_IDENTIFIER:
				_localctx = new BackQuotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(941);
				match(BACKQUOTED_IDENTIFIER);
				}
				break;
			case DIGIT_IDENTIFIER:
				_localctx = new DigitIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(942);
				match(DIGIT_IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	 
		public NumberContext() { }
		public void copyFrom(NumberContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DecimalLiteralContext extends NumberContext {
		public TerminalNode DECIMAL_VALUE() { return getToken(SqlBaseParser.DECIMAL_VALUE, 0); }
		public DecimalLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterDecimalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitDecimalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitDecimalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerLiteralContext extends NumberContext {
		public TerminalNode INTEGER_VALUE() { return getToken(SqlBaseParser.INTEGER_VALUE, 0); }
		public IntegerLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitIntegerLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitIntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_number);
		try {
			setState(947);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_VALUE:
				_localctx = new DecimalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(945);
				match(DECIMAL_VALUE);
				}
				break;
			case INTEGER_VALUE:
				_localctx = new IntegerLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(946);
				match(INTEGER_VALUE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonReservedContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(SqlBaseParser.ADD, 0); }
		public TerminalNode ALL() { return getToken(SqlBaseParser.ALL, 0); }
		public TerminalNode ANALYZE() { return getToken(SqlBaseParser.ANALYZE, 0); }
		public TerminalNode ANY() { return getToken(SqlBaseParser.ANY, 0); }
		public TerminalNode ARRAY() { return getToken(SqlBaseParser.ARRAY, 0); }
		public TerminalNode ASC() { return getToken(SqlBaseParser.ASC, 0); }
		public TerminalNode AT() { return getToken(SqlBaseParser.AT, 0); }
		public TerminalNode BERNOULLI() { return getToken(SqlBaseParser.BERNOULLI, 0); }
		public TerminalNode CALL() { return getToken(SqlBaseParser.CALL, 0); }
		public TerminalNode CASCADE() { return getToken(SqlBaseParser.CASCADE, 0); }
		public TerminalNode CATALOGS() { return getToken(SqlBaseParser.CATALOGS, 0); }
		public TerminalNode COALESCE() { return getToken(SqlBaseParser.COALESCE, 0); }
		public TerminalNode COLUMN() { return getToken(SqlBaseParser.COLUMN, 0); }
		public TerminalNode COLUMNS() { return getToken(SqlBaseParser.COLUMNS, 0); }
		public TerminalNode COMMENT() { return getToken(SqlBaseParser.COMMENT, 0); }
		public TerminalNode COMMIT() { return getToken(SqlBaseParser.COMMIT, 0); }
		public TerminalNode COMMITTED() { return getToken(SqlBaseParser.COMMITTED, 0); }
		public TerminalNode CURRENT() { return getToken(SqlBaseParser.CURRENT, 0); }
		public TerminalNode DATA() { return getToken(SqlBaseParser.DATA, 0); }
		public TerminalNode DATE() { return getToken(SqlBaseParser.DATE, 0); }
		public TerminalNode DAY() { return getToken(SqlBaseParser.DAY, 0); }
		public TerminalNode DESC() { return getToken(SqlBaseParser.DESC, 0); }
		public TerminalNode DISTRIBUTED() { return getToken(SqlBaseParser.DISTRIBUTED, 0); }
		public TerminalNode EXCLUDING() { return getToken(SqlBaseParser.EXCLUDING, 0); }
		public TerminalNode EXPLAIN() { return getToken(SqlBaseParser.EXPLAIN, 0); }
		public TerminalNode FILTER() { return getToken(SqlBaseParser.FILTER, 0); }
		public TerminalNode FIRST() { return getToken(SqlBaseParser.FIRST, 0); }
		public TerminalNode FOLLOWING() { return getToken(SqlBaseParser.FOLLOWING, 0); }
		public TerminalNode FORMAT() { return getToken(SqlBaseParser.FORMAT, 0); }
		public TerminalNode FUNCTIONS() { return getToken(SqlBaseParser.FUNCTIONS, 0); }
		public TerminalNode GRANT() { return getToken(SqlBaseParser.GRANT, 0); }
		public TerminalNode GRANTS() { return getToken(SqlBaseParser.GRANTS, 0); }
		public TerminalNode GRAPHVIZ() { return getToken(SqlBaseParser.GRAPHVIZ, 0); }
		public TerminalNode HOUR() { return getToken(SqlBaseParser.HOUR, 0); }
		public TerminalNode IF() { return getToken(SqlBaseParser.IF, 0); }
		public TerminalNode INCLUDING() { return getToken(SqlBaseParser.INCLUDING, 0); }
		public TerminalNode INPUT() { return getToken(SqlBaseParser.INPUT, 0); }
		public TerminalNode INTEGER() { return getToken(SqlBaseParser.INTEGER, 0); }
		public TerminalNode INTERVAL() { return getToken(SqlBaseParser.INTERVAL, 0); }
		public TerminalNode ISOLATION() { return getToken(SqlBaseParser.ISOLATION, 0); }
		public TerminalNode LAST() { return getToken(SqlBaseParser.LAST, 0); }
		public TerminalNode LATERAL() { return getToken(SqlBaseParser.LATERAL, 0); }
		public TerminalNode LEVEL() { return getToken(SqlBaseParser.LEVEL, 0); }
		public TerminalNode LIMIT() { return getToken(SqlBaseParser.LIMIT, 0); }
		public TerminalNode LOGICAL() { return getToken(SqlBaseParser.LOGICAL, 0); }
		public TerminalNode MAP() { return getToken(SqlBaseParser.MAP, 0); }
		public TerminalNode MINUTE() { return getToken(SqlBaseParser.MINUTE, 0); }
		public TerminalNode MONTH() { return getToken(SqlBaseParser.MONTH, 0); }
		public TerminalNode NFC() { return getToken(SqlBaseParser.NFC, 0); }
		public TerminalNode NFD() { return getToken(SqlBaseParser.NFD, 0); }
		public TerminalNode NFKC() { return getToken(SqlBaseParser.NFKC, 0); }
		public TerminalNode NFKD() { return getToken(SqlBaseParser.NFKD, 0); }
		public TerminalNode NO() { return getToken(SqlBaseParser.NO, 0); }
		public TerminalNode NULLIF() { return getToken(SqlBaseParser.NULLIF, 0); }
		public TerminalNode NULLS() { return getToken(SqlBaseParser.NULLS, 0); }
		public TerminalNode ONLY() { return getToken(SqlBaseParser.ONLY, 0); }
		public TerminalNode OPTION() { return getToken(SqlBaseParser.OPTION, 0); }
		public TerminalNode ORDINALITY() { return getToken(SqlBaseParser.ORDINALITY, 0); }
		public TerminalNode OUTPUT() { return getToken(SqlBaseParser.OUTPUT, 0); }
		public TerminalNode OVER() { return getToken(SqlBaseParser.OVER, 0); }
		public TerminalNode PARTITION() { return getToken(SqlBaseParser.PARTITION, 0); }
		public TerminalNode PARTITIONS() { return getToken(SqlBaseParser.PARTITIONS, 0); }
		public TerminalNode POSITION() { return getToken(SqlBaseParser.POSITION, 0); }
		public TerminalNode PRECEDING() { return getToken(SqlBaseParser.PRECEDING, 0); }
		public TerminalNode PRIVILEGES() { return getToken(SqlBaseParser.PRIVILEGES, 0); }
		public TerminalNode PROPERTIES() { return getToken(SqlBaseParser.PROPERTIES, 0); }
		public TerminalNode PUBLIC() { return getToken(SqlBaseParser.PUBLIC, 0); }
		public TerminalNode RANGE() { return getToken(SqlBaseParser.RANGE, 0); }
		public TerminalNode READ() { return getToken(SqlBaseParser.READ, 0); }
		public TerminalNode RENAME() { return getToken(SqlBaseParser.RENAME, 0); }
		public TerminalNode REPEATABLE() { return getToken(SqlBaseParser.REPEATABLE, 0); }
		public TerminalNode REPLACE() { return getToken(SqlBaseParser.REPLACE, 0); }
		public TerminalNode RESET() { return getToken(SqlBaseParser.RESET, 0); }
		public TerminalNode RESTRICT() { return getToken(SqlBaseParser.RESTRICT, 0); }
		public TerminalNode REVOKE() { return getToken(SqlBaseParser.REVOKE, 0); }
		public TerminalNode ROLLBACK() { return getToken(SqlBaseParser.ROLLBACK, 0); }
		public TerminalNode ROW() { return getToken(SqlBaseParser.ROW, 0); }
		public TerminalNode ROWS() { return getToken(SqlBaseParser.ROWS, 0); }
		public TerminalNode SCHEMA() { return getToken(SqlBaseParser.SCHEMA, 0); }
		public TerminalNode SCHEMAS() { return getToken(SqlBaseParser.SCHEMAS, 0); }
		public TerminalNode SECOND() { return getToken(SqlBaseParser.SECOND, 0); }
		public TerminalNode SESSION() { return getToken(SqlBaseParser.SESSION, 0); }
		public TerminalNode SET() { return getToken(SqlBaseParser.SET, 0); }
		public TerminalNode SETS() { return getToken(SqlBaseParser.SETS, 0); }
		public TerminalNode SHOW() { return getToken(SqlBaseParser.SHOW, 0); }
		public TerminalNode SMALLINT() { return getToken(SqlBaseParser.SMALLINT, 0); }
		public TerminalNode SOME() { return getToken(SqlBaseParser.SOME, 0); }
		public TerminalNode START() { return getToken(SqlBaseParser.START, 0); }
		public TerminalNode STATS() { return getToken(SqlBaseParser.STATS, 0); }
		public TerminalNode SUBSTRING() { return getToken(SqlBaseParser.SUBSTRING, 0); }
		public TerminalNode SYSTEM() { return getToken(SqlBaseParser.SYSTEM, 0); }
		public TerminalNode TABLES() { return getToken(SqlBaseParser.TABLES, 0); }
		public TerminalNode TABLESAMPLE() { return getToken(SqlBaseParser.TABLESAMPLE, 0); }
		public TerminalNode TEXT() { return getToken(SqlBaseParser.TEXT, 0); }
		public TerminalNode TIME() { return getToken(SqlBaseParser.TIME, 0); }
		public TerminalNode TIMESTAMP() { return getToken(SqlBaseParser.TIMESTAMP, 0); }
		public TerminalNode TINYINT() { return getToken(SqlBaseParser.TINYINT, 0); }
		public TerminalNode TO() { return getToken(SqlBaseParser.TO, 0); }
		public TerminalNode TRY_CAST() { return getToken(SqlBaseParser.TRY_CAST, 0); }
		public TerminalNode TYPE() { return getToken(SqlBaseParser.TYPE, 0); }
		public TerminalNode UNBOUNDED() { return getToken(SqlBaseParser.UNBOUNDED, 0); }
		public TerminalNode UNCOMMITTED() { return getToken(SqlBaseParser.UNCOMMITTED, 0); }
		public TerminalNode USE() { return getToken(SqlBaseParser.USE, 0); }
		public TerminalNode VALIDATE() { return getToken(SqlBaseParser.VALIDATE, 0); }
		public TerminalNode VERBOSE() { return getToken(SqlBaseParser.VERBOSE, 0); }
		public TerminalNode VIEW() { return getToken(SqlBaseParser.VIEW, 0); }
		public TerminalNode WORK() { return getToken(SqlBaseParser.WORK, 0); }
		public TerminalNode WRITE() { return getToken(SqlBaseParser.WRITE, 0); }
		public TerminalNode YEAR() { return getToken(SqlBaseParser.YEAR, 0); }
		public TerminalNode ZONE() { return getToken(SqlBaseParser.ZONE, 0); }
		public NonReservedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonReserved; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).enterNonReserved(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlBaseListener ) ((SqlBaseListener)listener).exitNonReserved(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlBaseVisitor ) return ((SqlBaseVisitor<? extends T>)visitor).visitNonReserved(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonReservedContext nonReserved() throws RecognitionException {
		NonReservedContext _localctx = new NonReservedContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_nonReserved);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(949);
			_la = _input.LA(1);
			if ( !(((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & ((1L << (ADD - 5)) | (1L << (ALL - 5)) | (1L << (ANALYZE - 5)) | (1L << (ANY - 5)) | (1L << (ARRAY - 5)) | (1L << (ASC - 5)) | (1L << (AT - 5)) | (1L << (BERNOULLI - 5)) | (1L << (CALL - 5)) | (1L << (CASCADE - 5)) | (1L << (CATALOGS - 5)) | (1L << (COALESCE - 5)) | (1L << (COLUMN - 5)) | (1L << (COLUMNS - 5)) | (1L << (COMMENT - 5)) | (1L << (COMMIT - 5)) | (1L << (COMMITTED - 5)) | (1L << (CURRENT - 5)) | (1L << (DATA - 5)) | (1L << (DATE - 5)) | (1L << (DAY - 5)) | (1L << (DESC - 5)) | (1L << (DISTRIBUTED - 5)) | (1L << (EXCLUDING - 5)) | (1L << (EXPLAIN - 5)) | (1L << (FILTER - 5)) | (1L << (FIRST - 5)) | (1L << (FOLLOWING - 5)) | (1L << (FORMAT - 5)))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (FUNCTIONS - 70)) | (1L << (GRANT - 70)) | (1L << (GRANTS - 70)) | (1L << (GRAPHVIZ - 70)) | (1L << (HOUR - 70)) | (1L << (IF - 70)) | (1L << (INCLUDING - 70)) | (1L << (INPUT - 70)) | (1L << (INTEGER - 70)) | (1L << (INTERVAL - 70)) | (1L << (ISOLATION - 70)) | (1L << (LAST - 70)) | (1L << (LATERAL - 70)) | (1L << (LEVEL - 70)) | (1L << (LIMIT - 70)) | (1L << (LOGICAL - 70)) | (1L << (MAP - 70)) | (1L << (MINUTE - 70)) | (1L << (MONTH - 70)) | (1L << (NFC - 70)) | (1L << (NFD - 70)) | (1L << (NFKC - 70)) | (1L << (NFKD - 70)) | (1L << (NO - 70)) | (1L << (NULLIF - 70)) | (1L << (NULLS - 70)) | (1L << (ONLY - 70)) | (1L << (OPTION - 70)) | (1L << (ORDINALITY - 70)) | (1L << (OUTPUT - 70)) | (1L << (OVER - 70)) | (1L << (PARTITION - 70)) | (1L << (PARTITIONS - 70)) | (1L << (POSITION - 70)) | (1L << (PRECEDING - 70)) | (1L << (PRIVILEGES - 70)) | (1L << (PROPERTIES - 70)))) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (PUBLIC - 134)) | (1L << (RANGE - 134)) | (1L << (READ - 134)) | (1L << (RENAME - 134)) | (1L << (REPEATABLE - 134)) | (1L << (REPLACE - 134)) | (1L << (RESET - 134)) | (1L << (RESTRICT - 134)) | (1L << (REVOKE - 134)) | (1L << (ROLLBACK - 134)) | (1L << (ROW - 134)) | (1L << (ROWS - 134)) | (1L << (SCHEMA - 134)) | (1L << (SCHEMAS - 134)) | (1L << (SECOND - 134)) | (1L << (SESSION - 134)) | (1L << (SET - 134)) | (1L << (SETS - 134)) | (1L << (SHOW - 134)) | (1L << (SMALLINT - 134)) | (1L << (SOME - 134)) | (1L << (START - 134)) | (1L << (STATS - 134)) | (1L << (SUBSTRING - 134)) | (1L << (SYSTEM - 134)) | (1L << (TABLES - 134)) | (1L << (TABLESAMPLE - 134)) | (1L << (TEXT - 134)) | (1L << (TIME - 134)) | (1L << (TIMESTAMP - 134)) | (1L << (TINYINT - 134)) | (1L << (TO - 134)) | (1L << (TRY_CAST - 134)) | (1L << (TYPE - 134)) | (1L << (UNBOUNDED - 134)) | (1L << (UNCOMMITTED - 134)) | (1L << (USE - 134)) | (1L << (VALIDATE - 134)) | (1L << (VERBOSE - 134)) | (1L << (VIEW - 134)) | (1L << (WORK - 134)) | (1L << (WRITE - 134)) | (1L << (YEAR - 134)) | (1L << (ZONE - 134)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 28:
			return booleanExpression_sempred((BooleanExpressionContext)_localctx, predIndex);
		case 31:
			return valueExpression_sempred((ValueExpressionContext)_localctx, predIndex);
		case 32:
			return primaryExpression_sempred((PrimaryExpressionContext)_localctx, predIndex);
		case 37:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean booleanExpression_sempred(BooleanExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean valueExpression_sempred(ValueExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean primaryExpression_sempred(PrimaryExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u00e4\u03ba\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\7\4q\n\4\f\4\16\4t\13\4\3\4\3\4\5\4x\n\4\5\4"+
		"z\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0088\n\7\3"+
		"\b\3\b\5\b\u008c\n\b\3\b\3\b\3\b\7\b\u0091\n\b\f\b\16\b\u0094\13\b\3\b"+
		"\3\b\3\b\3\b\7\b\u009a\n\b\f\b\16\b\u009d\13\b\5\b\u009f\n\b\3\b\3\b\5"+
		"\b\u00a3\n\b\3\b\3\b\3\b\3\b\3\b\7\b\u00aa\n\b\f\b\16\b\u00ad\13\b\5\b"+
		"\u00af\n\b\3\b\3\b\5\b\u00b3\n\b\3\b\5\b\u00b6\n\b\3\b\3\b\5\b\u00ba\n"+
		"\b\3\b\3\b\3\b\7\b\u00bf\n\b\f\b\16\b\u00c2\13\b\3\b\5\b\u00c5\n\b\3\b"+
		"\3\b\3\b\3\b\7\b\u00cb\n\b\f\b\16\b\u00ce\13\b\5\b\u00d0\n\b\3\b\3\b\5"+
		"\b\u00d4\n\b\3\b\3\b\3\b\3\b\3\b\7\b\u00db\n\b\f\b\16\b\u00de\13\b\5\b"+
		"\u00e0\n\b\3\b\3\b\5\b\u00e4\n\b\5\b\u00e6\n\b\3\t\3\t\5\t\u00ea\n\t\3"+
		"\t\3\t\3\t\7\t\u00ef\n\t\f\t\16\t\u00f2\13\t\3\t\3\t\3\t\3\t\5\t\u00f8"+
		"\n\t\3\t\3\t\3\t\5\t\u00fd\n\t\3\t\3\t\3\t\5\t\u0102\n\t\3\t\3\t\5\t\u0106"+
		"\n\t\3\t\5\t\u0109\n\t\3\t\5\t\u010c\n\t\3\t\5\t\u010f\n\t\5\t\u0111\n"+
		"\t\5\t\u0113\n\t\3\t\3\t\3\t\5\t\u0118\n\t\3\t\3\t\3\t\5\t\u011d\n\t\3"+
		"\t\3\t\5\t\u0121\n\t\3\t\3\t\3\t\3\t\3\t\7\t\u0128\n\t\f\t\16\t\u012b"+
		"\13\t\5\t\u012d\n\t\3\t\3\t\5\t\u0131\n\t\3\t\5\t\u0134\n\t\3\t\3\t\5"+
		"\t\u0138\n\t\3\t\3\t\3\t\7\t\u013d\n\t\f\t\16\t\u0140\13\t\3\t\5\t\u0143"+
		"\n\t\3\t\3\t\3\t\3\t\5\t\u0149\n\t\3\t\3\t\3\t\5\t\u014e\n\t\3\t\3\t\3"+
		"\t\5\t\u0153\n\t\3\t\3\t\5\t\u0157\n\t\3\t\5\t\u015a\n\t\3\t\5\t\u015d"+
		"\n\t\3\t\5\t\u0160\n\t\5\t\u0162\n\t\5\t\u0164\n\t\3\t\3\t\3\t\5\t\u0169"+
		"\n\t\3\t\3\t\3\t\5\t\u016e\n\t\3\t\3\t\5\t\u0172\n\t\3\t\3\t\3\t\3\t\3"+
		"\t\7\t\u0179\n\t\f\t\16\t\u017c\13\t\5\t\u017e\n\t\3\t\3\t\5\t\u0182\n"+
		"\t\3\t\3\t\5\t\u0186\n\t\3\t\3\t\3\t\7\t\u018b\n\t\f\t\16\t\u018e\13\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0198\n\t\3\t\3\t\5\t\u019c\n\t\3"+
		"\t\5\t\u019f\n\t\3\t\5\t\u01a2\n\t\3\t\5\t\u01a5\n\t\5\t\u01a7\n\t\5\t"+
		"\u01a9\n\t\3\t\3\t\3\t\5\t\u01ae\n\t\3\t\3\t\3\t\5\t\u01b3\n\t\3\t\3\t"+
		"\5\t\u01b7\n\t\3\t\3\t\3\t\3\t\3\t\7\t\u01be\n\t\f\t\16\t\u01c1\13\t\5"+
		"\t\u01c3\n\t\3\t\3\t\5\t\u01c7\n\t\3\t\5\t\u01ca\n\t\3\t\3\t\5\t\u01ce"+
		"\n\t\3\t\3\t\3\t\7\t\u01d3\n\t\f\t\16\t\u01d6\13\t\3\t\5\t\u01d9\n\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u01e3\n\t\3\t\3\t\5\t\u01e7\n\t\3\t"+
		"\5\t\u01ea\n\t\3\t\5\t\u01ed\n\t\3\t\5\t\u01f0\n\t\5\t\u01f2\n\t\5\t\u01f4"+
		"\n\t\3\t\3\t\3\t\5\t\u01f9\n\t\3\t\3\t\3\t\5\t\u01fe\n\t\3\t\3\t\5\t\u0202"+
		"\n\t\3\t\3\t\3\t\3\t\3\t\7\t\u0209\n\t\f\t\16\t\u020c\13\t\5\t\u020e\n"+
		"\t\3\t\3\t\5\t\u0212\n\t\5\t\u0214\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\5\n\u0220\n\n\3\13\3\13\3\13\3\13\5\13\u0226\n\13\3\f\3\f\5\f"+
		"\u022a\n\f\3\f\3\f\5\f\u022e\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\5\23\u0247\n\23\3\23\5\23\u024a\n\23\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u0251\n\23\3\24\3\24\3\24\3\24\3\24\5\24\u0258\n\24\3\24\3\24\5\24\u025c"+
		"\n\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\30\5\30\u0269"+
		"\n\30\3\30\3\30\5\30\u026d\n\30\3\30\3\30\5\30\u0271\n\30\3\30\3\30\5"+
		"\30\u0275\n\30\5\30\u0277\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31"+
		"\u0280\n\31\f\31\16\31\u0283\13\31\3\31\3\31\5\31\u0287\n\31\3\32\3\32"+
		"\5\32\u028b\n\32\3\32\3\32\3\32\3\32\3\32\5\32\u0292\n\32\5\32\u0294\n"+
		"\32\3\33\3\33\3\33\7\33\u0299\n\33\f\33\16\33\u029c\13\33\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u02a7\n\34\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\5\36\u02af\n\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u02b7\n"+
		"\36\f\36\16\36\u02ba\13\36\3\37\3\37\5\37\u02be\n\37\3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \5 \u02ca\n \3 \3 \3 \3 \3 \3 \5 \u02d2\n \3 \3 \3 \3 \3"+
		" \7 \u02d9\n \f \16 \u02dc\13 \3 \3 \3 \5 \u02e1\n \3 \3 \3 \3 \3 \3 "+
		"\5 \u02e9\n \3 \3 \3 \3 \5 \u02ef\n \3 \3 \5 \u02f3\n \3 \3 \3 \5 \u02f8"+
		"\n \3 \3 \3 \5 \u02fd\n \3!\3!\3!\3!\5!\u0303\n!\3!\3!\3!\3!\3!\3!\3!"+
		"\3!\3!\7!\u030e\n!\f!\16!\u0311\13!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0323\n\"\3\"\3\"\3\"\5\"\u0328\n\""+
		"\3\"\3\"\3\"\7\"\u032d\n\"\f\"\16\"\u0330\13\"\5\"\u0332\n\"\3\"\3\"\5"+
		"\"\u0336\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5"+
		"\"\u0346\n\"\3\"\3\"\3\"\7\"\u034b\n\"\f\"\16\"\u034e\13\"\3#\3#\3#\3"+
		"#\5#\u0354\n#\5#\u0356\n#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u0373\n"+
		"\'\f\'\16\'\u0376\13\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u037f\n\'\f\'\16"+
		"\'\u0382\13\'\3\'\3\'\5\'\u0386\n\'\5\'\u0388\n\'\3\'\3\'\7\'\u038c\n"+
		"\'\f\'\16\'\u038f\13\'\3(\3(\5(\u0393\n(\3)\3)\3)\3)\5)\u0399\n)\3*\3"+
		"*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,\3,\7,\u03a9\n,\f,\16,\u03ac\13,\3-"+
		"\3-\3-\3-\5-\u03b2\n-\3.\3.\5.\u03b6\n.\3/\3/\3/\2\6:@BL\60\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\"+
		"\2\16\4\2\b\b\u00d7\u00d7\4\2\17\17--\4\2BB^^\5\2\"\"gh\u00a7\u00a7\4"+
		"\2\b\b\60\60\4\2\33\33??\3\2\u00ce\u00cf\3\2\u00d0\u00d2\3\2\u00c8\u00cd"+
		"\5\2\b\b\f\f\u00a1\u00a1\4\2>>\u00b3\u00b3\63\2\7\b\n\n\f\r\17\21\24\25"+
		"\30\33\35\37\'*--\61\6199<<ACEEHKOPSSUUWWYY\\\\^_aaccefjkmqtuwx||\177"+
		"\u0084\u0086\u0089\u008b\u008b\u008d\u0092\u0094\u0094\u0096\u009a\u009c"+
		"\u00a1\u00a3\u00a3\u00a5\u00a6\u00a8\u00a8\u00aa\u00ab\u00ad\u00ad\u00af"+
		"\u00b2\u00b4\u00b5\u00b7\u00b8\u00bb\u00bb\u00bd\u00bd\u00bf\u00c0\u00c4"+
		"\u00c7\2\u043f\2^\3\2\2\2\4a\3\2\2\2\6y\3\2\2\2\b{\3\2\2\2\n}\3\2\2\2"+
		"\f\u0087\3\2\2\2\16\u00e5\3\2\2\2\20\u0213\3\2\2\2\22\u021f\3\2\2\2\24"+
		"\u0221\3\2\2\2\26\u0227\3\2\2\2\30\u022f\3\2\2\2\32\u0233\3\2\2\2\34\u0236"+
		"\3\2\2\2\36\u023b\3\2\2\2 \u0240\3\2\2\2\"\u0242\3\2\2\2$\u0250\3\2\2"+
		"\2&\u0252\3\2\2\2(\u025d\3\2\2\2*\u0261\3\2\2\2,\u0265\3\2\2\2.\u0276"+
		"\3\2\2\2\60\u0286\3\2\2\2\62\u0288\3\2\2\2\64\u0295\3\2\2\2\66\u02a6\3"+
		"\2\2\28\u02a8\3\2\2\2:\u02ae\3\2\2\2<\u02bb\3\2\2\2>\u02fc\3\2\2\2@\u0302"+
		"\3\2\2\2B\u0345\3\2\2\2D\u0355\3\2\2\2F\u0357\3\2\2\2H\u0359\3\2\2\2J"+
		"\u035b\3\2\2\2L\u0387\3\2\2\2N\u0392\3\2\2\2P\u0398\3\2\2\2R\u039a\3\2"+
		"\2\2T\u039f\3\2\2\2V\u03a5\3\2\2\2X\u03b1\3\2\2\2Z\u03b5\3\2\2\2\\\u03b7"+
		"\3\2\2\2^_\5\6\4\2_`\7\2\2\3`\3\3\2\2\2ab\58\35\2bc\7\2\2\3c\5\3\2\2\2"+
		"dz\5\b\5\2ef\7Q\2\2fg\7F\2\2gh\7$\2\2hi\7@\2\2ij\7\u00d4\2\2jk\7Z\2\2"+
		"kw\5V,\2lm\7\3\2\2mr\5\24\13\2no\7\4\2\2oq\5\24\13\2pn\3\2\2\2qt\3\2\2"+
		"\2rp\3\2\2\2rs\3\2\2\2su\3\2\2\2tr\3\2\2\2uv\7\5\2\2vx\3\2\2\2wl\3\2\2"+
		"\2wx\3\2\2\2xz\3\2\2\2yd\3\2\2\2ye\3\2\2\2z\7\3\2\2\2{|\5\n\6\2|\t\3\2"+
		"\2\2}~\5\f\7\2~\13\3\2\2\2\177\u0088\5\16\b\2\u0080\u0088\5\20\t\2\u0081"+
		"\u0082\7\u00a9\2\2\u0082\u0088\5V,\2\u0083\u0084\7\3\2\2\u0084\u0085\5"+
		"\b\5\2\u0085\u0086\7\5\2\2\u0086\u0088\3\2\2\2\u0087\177\3\2\2\2\u0087"+
		"\u0080\3\2\2\2\u0087\u0081\3\2\2\2\u0087\u0083\3\2\2\2\u0088\r\3\2\2\2"+
		"\u0089\u008b\7\u009b\2\2\u008a\u008c\5\"\22\2\u008b\u008a\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u0092\5$\23\2\u008e\u008f\7\4"+
		"\2\2\u008f\u0091\5$\23\2\u0090\u008e\3\2\2\2\u0091\u0094\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u009e\3\2\2\2\u0094\u0092\3\2"+
		"\2\2\u0095\u0096\7F\2\2\u0096\u009b\5,\27\2\u0097\u0098\7\4\2\2\u0098"+
		"\u009a\5,\27\2\u0099\u0097\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2"+
		"\2\2\u009b\u009c\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009e"+
		"\u0095\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u00a1\7\u00c2"+
		"\2\2\u00a1\u00a3\5:\36\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00ae\3\2\2\2\u00a4\u00a5\7{\2\2\u00a5\u00a6\7\23\2\2\u00a6\u00ab\5\26"+
		"\f\2\u00a7\u00a8\7\4\2\2\u00a8\u00aa\5\26\f\2\u00a9\u00a7\3\2\2\2\u00aa"+
		"\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00af\3\2"+
		"\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00a4\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00b2\3\2\2\2\u00b0\u00b1\7c\2\2\u00b1\u00b3\t\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b6\5&\24\2\u00b5"+
		"\u00b4\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00e6\3\2\2\2\u00b7\u00b9\7\u009b"+
		"\2\2\u00b8\u00ba\5\"\22\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb\u00c0\5$\23\2\u00bc\u00bd\7\4\2\2\u00bd\u00bf\5$"+
		"\23\2\u00be\u00bc\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c5\5&"+
		"\24\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00cf\3\2\2\2\u00c6"+
		"\u00c7\7F\2\2\u00c7\u00cc\5,\27\2\u00c8\u00c9\7\4\2\2\u00c9\u00cb\5,\27"+
		"\2\u00ca\u00c8\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd"+
		"\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00c6\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00d2\7\u00c2\2\2\u00d2\u00d4"+
		"\5:\36\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00df\3\2\2\2\u00d5"+
		"\u00d6\7{\2\2\u00d6\u00d7\7\23\2\2\u00d7\u00dc\5\26\f\2\u00d8\u00d9\7"+
		"\4\2\2\u00d9\u00db\5\26\f\2\u00da\u00d8\3\2\2\2\u00db\u00de\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2"+
		"\2\2\u00df\u00d5\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1"+
		"\u00e2\7c\2\2\u00e2\u00e4\t\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2"+
		"\2\2\u00e4\u00e6\3\2\2\2\u00e5\u0089\3\2\2\2\u00e5\u00b7\3\2\2\2\u00e6"+
		"\17\3\2\2\2\u00e7\u00e9\7\u009b\2\2\u00e8\u00ea\5\"\22\2\u00e9\u00e8\3"+
		"\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00f0\5$\23\2\u00ec"+
		"\u00ed\7\4\2\2\u00ed\u00ef\5$\23\2\u00ee\u00ec\3\2\2\2\u00ef\u00f2\3\2"+
		"\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2"+
		"\u00f0\3\2\2\2\u00f3\u00f4\7F\2\2\u00f4\u00f5\7/\2\2\u00f5\u00f7\5\n\6"+
		"\2\u00f6\u00f8\5V,\2\u00f7\u00f6\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9"+
		"\3\2\2\2\u00f9\u00fa\7\4\2\2\u00fa\u00fc\5\n\6\2\u00fb\u00fd\5V,\2\u00fc"+
		"\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0101\7v"+
		"\2\2\u00ff\u0102\5\64\33\2\u0100\u0102\7\u00d0\2\2\u0101\u00ff\3\2\2\2"+
		"\u0101\u0100\3\2\2\2\u0102\u0112\3\2\2\2\u0103\u0110\7\u00c3\2\2\u0104"+
		"\u0106\5\30\r\2\u0105\u0104\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108\3"+
		"\2\2\2\u0107\u0109\5\32\16\2\u0108\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u0111\3\2\2\2\u010a\u010c\5\32\16\2\u010b\u010a\3\2\2\2\u010b\u010c\3"+
		"\2\2\2\u010c\u010e\3\2\2\2\u010d\u010f\5\30\r\2\u010e\u010d\3\2\2\2\u010e"+
		"\u010f\3\2\2\2\u010f\u0111\3\2\2\2\u0110\u0105\3\2\2\2\u0110\u010b\3\2"+
		"\2\2\u0111\u0113\3\2\2\2\u0112\u0103\3\2\2\2\u0112\u0113\3\2\2\2\u0113"+
		"\u0117\3\2\2\2\u0114\u0115\7 \2\2\u0115\u0116\7\23\2\2\u0116\u0118\5\34"+
		"\17\2\u0117\u0114\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u011c\3\2\2\2\u0119"+
		"\u011a\7g\2\2\u011a\u011b\7\34\2\2\u011b\u011d\7\u00d7\2\2\u011c\u0119"+
		"\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011f\7\u00c2\2"+
		"\2\u011f\u0121\5:\36\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u012c"+
		"\3\2\2\2\u0122\u0123\7{\2\2\u0123\u0124\7\23\2\2\u0124\u0129\5\26\f\2"+
		"\u0125\u0126\7\4\2\2\u0126\u0128\5\26\f\2\u0127\u0125\3\2\2\2\u0128\u012b"+
		"\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012d\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012c\u0122\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u0130\3\2"+
		"\2\2\u012e\u012f\7c\2\2\u012f\u0131\t\2\2\2\u0130\u012e\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u0133\3\2\2\2\u0132\u0134\5&\24\2\u0133\u0132\3\2"+
		"\2\2\u0133\u0134\3\2\2\2\u0134\u0214\3\2\2\2\u0135\u0137\7\u009b\2\2\u0136"+
		"\u0138\5\"\22\2\u0137\u0136\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139\3"+
		"\2\2\2\u0139\u013e\5$\23\2\u013a\u013b\7\4\2\2\u013b\u013d\5$\23\2\u013c"+
		"\u013a\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2"+
		"\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0143\5&\24\2\u0142"+
		"\u0141\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\7F"+
		"\2\2\u0145\u0146\7/\2\2\u0146\u0148\5\n\6\2\u0147\u0149\5V,\2\u0148\u0147"+
		"\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014b\7\4\2\2\u014b"+
		"\u014d\5\n\6\2\u014c\u014e\5V,\2\u014d\u014c\3\2\2\2\u014d\u014e\3\2\2"+
		"\2\u014e\u014f\3\2\2\2\u014f\u0152\7v\2\2\u0150\u0153\5\64\33\2\u0151"+
		"\u0153\7\u00d0\2\2\u0152\u0150\3\2\2\2\u0152\u0151\3\2\2\2\u0153\u0163"+
		"\3\2\2\2\u0154\u0161\7\u00c3\2\2\u0155\u0157\5\30\r\2\u0156\u0155\3\2"+
		"\2\2\u0156\u0157\3\2\2\2\u0157\u0159\3\2\2\2\u0158\u015a\5\32\16\2\u0159"+
		"\u0158\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u0162\3\2\2\2\u015b\u015d\5\32"+
		"\16\2\u015c\u015b\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015f\3\2\2\2\u015e"+
		"\u0160\5\30\r\2\u015f\u015e\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0162\3"+
		"\2\2\2\u0161\u0156\3\2\2\2\u0161\u015c\3\2\2\2\u0162\u0164\3\2\2\2\u0163"+
		"\u0154\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0168\3\2\2\2\u0165\u0166\7 "+
		"\2\2\u0166\u0167\7\23\2\2\u0167\u0169\5\34\17\2\u0168\u0165\3\2\2\2\u0168"+
		"\u0169\3\2\2\2\u0169\u016d\3\2\2\2\u016a\u016b\7g\2\2\u016b\u016c\7\34"+
		"\2\2\u016c\u016e\7\u00d7\2\2\u016d\u016a\3\2\2\2\u016d\u016e\3\2\2\2\u016e"+
		"\u0171\3\2\2\2\u016f\u0170\7\u00c2\2\2\u0170\u0172\5:\36\2\u0171\u016f"+
		"\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u017d\3\2\2\2\u0173\u0174\7{\2\2\u0174"+
		"\u0175\7\23\2\2\u0175\u017a\5\26\f\2\u0176\u0177\7\4\2\2\u0177\u0179\5"+
		"\26\f\2\u0178\u0176\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a"+
		"\u017b\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u0173\3\2"+
		"\2\2\u017d\u017e\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u0180\7c\2\2\u0180"+
		"\u0182\t\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0214\3\2"+
		"\2\2\u0183\u0185\7\u009b\2\2\u0184\u0186\5\"\22\2\u0185\u0184\3\2\2\2"+
		"\u0185\u0186\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u018c\5$\23\2\u0188\u0189"+
		"\7\4\2\2\u0189\u018b\5$\23\2\u018a\u0188\3\2\2\2\u018b\u018e\3\2\2\2\u018c"+
		"\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018f\3\2\2\2\u018e\u018c\3\2"+
		"\2\2\u018f\u0190\7F\2\2\u0190\u0191\7/\2\2\u0191\u0192\7\3\2\2\u0192\u0193"+
		"\5\22\n\2\u0193\u0194\7\5\2\2\u0194\u0197\7v\2\2\u0195\u0198\5\64\33\2"+
		"\u0196\u0198\7\u00d0\2\2\u0197\u0195\3\2\2\2\u0197\u0196\3\2\2\2\u0198"+
		"\u01a8\3\2\2\2\u0199\u01a6\7\u00c3\2\2\u019a\u019c\5\30\r\2\u019b\u019a"+
		"\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019e\3\2\2\2\u019d\u019f\5\32\16\2"+
		"\u019e\u019d\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a7\3\2\2\2\u01a0\u01a2"+
		"\5\32\16\2\u01a1\u01a0\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a4\3\2\2\2"+
		"\u01a3\u01a5\5\30\r\2\u01a4\u01a3\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a7"+
		"\3\2\2\2\u01a6\u019b\3\2\2\2\u01a6\u01a1\3\2\2\2\u01a7\u01a9\3\2\2\2\u01a8"+
		"\u0199\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01ad\3\2\2\2\u01aa\u01ab\7 "+
		"\2\2\u01ab\u01ac\7\23\2\2\u01ac\u01ae\5\34\17\2\u01ad\u01aa\3\2\2\2\u01ad"+
		"\u01ae\3\2\2\2\u01ae\u01b2\3\2\2\2\u01af\u01b0\7g\2\2\u01b0\u01b1\7\34"+
		"\2\2\u01b1\u01b3\7\u00d7\2\2\u01b2\u01af\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3"+
		"\u01b6\3\2\2\2\u01b4\u01b5\7\u00c2\2\2\u01b5\u01b7\5:\36\2\u01b6\u01b4"+
		"\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01c2\3\2\2\2\u01b8\u01b9\7{\2\2\u01b9"+
		"\u01ba\7\23\2\2\u01ba\u01bf\5\26\f\2\u01bb\u01bc\7\4\2\2\u01bc\u01be\5"+
		"\26\f\2\u01bd\u01bb\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf"+
		"\u01c0\3\2\2\2\u01c0\u01c3\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2\u01b8\3\2"+
		"\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c5\7c\2\2\u01c5"+
		"\u01c7\t\2\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c9\3\2"+
		"\2\2\u01c8\u01ca\5&\24\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca"+
		"\u0214\3\2\2\2\u01cb\u01cd\7\u009b\2\2\u01cc\u01ce\5\"\22\2\u01cd\u01cc"+
		"\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d4\5$\23\2\u01d0"+
		"\u01d1\7\4\2\2\u01d1\u01d3\5$\23\2\u01d2\u01d0\3\2\2\2\u01d3\u01d6\3\2"+
		"\2\2\u01d4\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6"+
		"\u01d4\3\2\2\2\u01d7\u01d9\5&\24\2\u01d8\u01d7\3\2\2\2\u01d8\u01d9\3\2"+
		"\2\2\u01d9\u01da\3\2\2\2\u01da\u01db\7F\2\2\u01db\u01dc\7/\2\2\u01dc\u01dd"+
		"\7\3\2\2\u01dd\u01de\5\22\n\2\u01de\u01df\7\5\2\2\u01df\u01e2\7v\2\2\u01e0"+
		"\u01e3\5\64\33\2\u01e1\u01e3\7\u00d0\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e1"+
		"\3\2\2\2\u01e3\u01f3\3\2\2\2\u01e4\u01f1\7\u00c3\2\2\u01e5\u01e7\5\30"+
		"\r\2\u01e6\u01e5\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e9\3\2\2\2\u01e8"+
		"\u01ea\5\32\16\2\u01e9\u01e8\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01f2\3"+
		"\2\2\2\u01eb\u01ed\5\32\16\2\u01ec\u01eb\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed"+
		"\u01ef\3\2\2\2\u01ee\u01f0\5\30\r\2\u01ef\u01ee\3\2\2\2\u01ef\u01f0\3"+
		"\2\2\2\u01f0\u01f2\3\2\2\2\u01f1\u01e6\3\2\2\2\u01f1\u01ec\3\2\2\2\u01f2"+
		"\u01f4\3\2\2\2\u01f3\u01e4\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f8\3\2"+
		"\2\2\u01f5\u01f6\7 \2\2\u01f6\u01f7\7\23\2\2\u01f7\u01f9\5\34\17\2\u01f8"+
		"\u01f5\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fd\3\2\2\2\u01fa\u01fb\7g"+
		"\2\2\u01fb\u01fc\7\34\2\2\u01fc\u01fe\7\u00d7\2\2\u01fd\u01fa\3\2\2\2"+
		"\u01fd\u01fe\3\2\2\2\u01fe\u0201\3\2\2\2\u01ff\u0200\7\u00c2\2\2\u0200"+
		"\u0202\5:\36\2\u0201\u01ff\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u020d\3\2"+
		"\2\2\u0203\u0204\7{\2\2\u0204\u0205\7\23\2\2\u0205\u020a\5\26\f\2\u0206"+
		"\u0207\7\4\2\2\u0207\u0209\5\26\f\2\u0208\u0206\3\2\2\2\u0209\u020c\3"+
		"\2\2\2\u020a\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020e\3\2\2\2\u020c"+
		"\u020a\3\2\2\2\u020d\u0203\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u0211\3\2"+
		"\2\2\u020f\u0210\7c\2\2\u0210\u0212\t\2\2\2\u0211\u020f\3\2\2\2\u0211"+
		"\u0212\3\2\2\2\u0212\u0214\3\2\2\2\u0213\u00e7\3\2\2\2\u0213\u0135\3\2"+
		"\2\2\u0213\u0183\3\2\2\2\u0213\u01cb\3\2\2\2\u0214\21\3\2\2\2\u0215\u0216"+
		"\7\u00a2\2\2\u0216\u0217\5,\27\2\u0217\u0218\7\u00c2\2\2\u0218\u0219\5"+
		":\36\2\u0219\u0220\3\2\2\2\u021a\u021b\7\u00a2\2\2\u021b\u021c\5\n\6\2"+
		"\u021c\u021d\7\u00c2\2\2\u021d\u021e\5:\36\2\u021e\u0220\3\2\2\2\u021f"+
		"\u0215\3\2\2\2\u021f\u021a\3\2\2\2\u0220\23\3\2\2\2\u0221\u0222\5X-\2"+
		"\u0222\u0225\5L\'\2\u0223\u0224\7\35\2\2\u0224\u0226\5D#\2\u0225\u0223"+
		"\3\2\2\2\u0225\u0226\3\2\2\2\u0226\25\3\2\2\2\u0227\u0229\58\35\2\u0228"+
		"\u022a\t\3\2\2\u0229\u0228\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022d\3\2"+
		"\2\2\u022b\u022c\7u\2\2\u022c\u022e\t\4\2\2\u022d\u022b\3\2\2\2\u022d"+
		"\u022e\3\2\2\2\u022e\27\3\2\2\2\u022f\u0230\7h\2\2\u0230\u0231\7\u008a"+
		"\2\2\u0231\u0232\7\u00d8\2\2\u0232\31\3\2\2\2\u0233\u0234\7i\2\2\u0234"+
		"\u0235\7\u00d8\2\2\u0235\33\3\2\2\2\u0236\u0237\5X-\2\u0237\u0238\7\3"+
		"\2\2\u0238\u0239\5\36\20\2\u0239\u023a\7\5\2\2\u023a\35\3\2\2\2\u023b"+
		"\u023c\5 \21\2\u023c\u023d\7\3\2\2\u023d\u023e\7\u00d0\2\2\u023e\u023f"+
		"\7\5\2\2\u023f\37\3\2\2\2\u0240\u0241\t\5\2\2\u0241!\3\2\2\2\u0242\u0243"+
		"\t\6\2\2\u0243#\3\2\2\2\u0244\u0249\58\35\2\u0245\u0247\7\16\2\2\u0246"+
		"\u0245\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u024a\5X"+
		"-\2\u0249\u0246\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u0251\3\2\2\2\u024b"+
		"\u024c\5V,\2\u024c\u024d\7\6\2\2\u024d\u024e\7\u00d0\2\2\u024e\u0251\3"+
		"\2\2\2\u024f\u0251\7\u00d0\2\2\u0250\u0244\3\2\2\2\u0250\u024b\3\2\2\2"+
		"\u0250\u024f\3\2\2\2\u0251%\3\2\2\2\u0252\u0253\7Z\2\2\u0253\u0254\7~"+
		"\2\2\u0254\u0257\7\u00d4\2\2\u0255\u0256\t\7\2\2\u0256\u0258\5(\25\2\u0257"+
		"\u0255\3\2\2\2\u0257\u0258\3\2\2\2\u0258\u025b\3\2\2\2\u0259\u025a\7d"+
		"\2\2\u025a\u025c\5(\25\2\u025b\u0259\3\2\2\2\u025b\u025c\3\2\2\2\u025c"+
		"\'\3\2\2\2\u025d\u025e\7\u00ac\2\2\u025e\u025f\7\23\2\2\u025f\u0260\7"+
		"\u00d4\2\2\u0260)\3\2\2\2\u0261\u0262\7\67\2\2\u0262\u0263\7\23\2\2\u0263"+
		"\u0264\7\u00d4\2\2\u0264+\3\2\2\2\u0265\u0266\5\62\32\2\u0266-\3\2\2\2"+
		"\u0267\u0269\7T\2\2\u0268\u0267\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u0277"+
		"\3\2\2\2\u026a\u026c\7`\2\2\u026b\u026d\7}\2\2\u026c\u026b\3\2\2\2\u026c"+
		"\u026d\3\2\2\2\u026d\u0277\3\2\2\2\u026e\u0270\7\u0093\2\2\u026f\u0271"+
		"\7}\2\2\u0270\u026f\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u0277\3\2\2\2\u0272"+
		"\u0274\7G\2\2\u0273\u0275\7}\2\2\u0274\u0273\3\2\2\2\u0274\u0275\3\2\2"+
		"\2\u0275\u0277\3\2\2\2\u0276\u0268\3\2\2\2\u0276\u026a\3\2\2\2\u0276\u026e"+
		"\3\2\2\2\u0276\u0272\3\2\2\2\u0277/\3\2\2\2\u0278\u0279\7v\2\2\u0279\u0287"+
		"\5:\36\2\u027a\u027b\7\u00bc\2\2\u027b\u027c\7\3\2\2\u027c\u0281\5X-\2"+
		"\u027d\u027e\7\4\2\2\u027e\u0280\5X-\2\u027f\u027d\3\2\2\2\u0280\u0283"+
		"\3\2\2\2\u0281\u027f\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0284\3\2\2\2\u0283"+
		"\u0281\3\2\2\2\u0284\u0285\7\5\2\2\u0285\u0287\3\2\2\2\u0286\u0278\3\2"+
		"\2\2\u0286\u027a\3\2\2\2\u0287\61\3\2\2\2\u0288\u0293\5\66\34\2\u0289"+
		"\u028b\7\16\2\2\u028a\u0289\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u028c\3"+
		"\2\2\2\u028c\u0291\5X-\2\u028d\u028e\7\3\2\2\u028e\u028f\5\64\33\2\u028f"+
		"\u0290\7\5\2\2\u0290\u0292\3\2\2\2\u0291\u028d\3\2\2\2\u0291\u0292\3\2"+
		"\2\2\u0292\u0294\3\2\2\2\u0293\u028a\3\2\2\2\u0293\u0294\3\2\2\2\u0294"+
		"\63\3\2\2\2\u0295\u029a\5X-\2\u0296\u0297\7\4\2\2\u0297\u0299\5X-\2\u0298"+
		"\u0296\3\2\2\2\u0299\u029c\3\2\2\2\u029a\u0298\3\2\2\2\u029a\u029b\3\2"+
		"\2\2\u029b\65\3\2\2\2\u029c\u029a\3\2\2\2\u029d\u02a7\5V,\2\u029e\u029f"+
		"\7\3\2\2\u029f\u02a0\5\b\5\2\u02a0\u02a1\7\5\2\2\u02a1\u02a7\3\2\2\2\u02a2"+
		"\u02a3\7\3\2\2\u02a3\u02a4\5,\27\2\u02a4\u02a5\7\5\2\2\u02a5\u02a7\3\2"+
		"\2\2\u02a6\u029d\3\2\2\2\u02a6\u029e\3\2\2\2\u02a6\u02a2\3\2\2\2\u02a7"+
		"\67\3\2\2\2\u02a8\u02a9\5:\36\2\u02a99\3\2\2\2\u02aa\u02ab\b\36\1\2\u02ab"+
		"\u02af\5<\37\2\u02ac\u02ad\7r\2\2\u02ad\u02af\5:\36\5\u02ae\u02aa\3\2"+
		"\2\2\u02ae\u02ac\3\2\2\2\u02af\u02b8\3\2\2\2\u02b0\u02b1\f\4\2\2\u02b1"+
		"\u02b2\7\13\2\2\u02b2\u02b7\5:\36\5\u02b3\u02b4\f\3\2\2\u02b4\u02b5\7"+
		"z\2\2\u02b5\u02b7\5:\36\4\u02b6\u02b0\3\2\2\2\u02b6\u02b3\3\2\2\2\u02b7"+
		"\u02ba\3\2\2\2\u02b8\u02b6\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9;\3\2\2\2"+
		"\u02ba\u02b8\3\2\2\2\u02bb\u02bd\5@!\2\u02bc\u02be\5> \2\u02bd\u02bc\3"+
		"\2\2\2\u02bd\u02be\3\2\2\2\u02be=\3\2\2\2\u02bf\u02c0\5F$\2\u02c0\u02c1"+
		"\5@!\2\u02c1\u02fd\3\2\2\2\u02c2\u02c3\5F$\2\u02c3\u02c4\5H%\2\u02c4\u02c5"+
		"\7\3\2\2\u02c5\u02c6\5\b\5\2\u02c6\u02c7\7\5\2\2\u02c7\u02fd\3\2\2\2\u02c8"+
		"\u02ca\7r\2\2\u02c9\u02c8\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02cb\3\2"+
		"\2\2\u02cb\u02cc\7\22\2\2\u02cc\u02cd\5@!\2\u02cd\u02ce\7\13\2\2\u02ce"+
		"\u02cf\5@!\2\u02cf\u02fd\3\2\2\2\u02d0\u02d2\7r\2\2\u02d1\u02d0\3\2\2"+
		"\2\u02d1\u02d2\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3\u02d4\7R\2\2\u02d4\u02d5"+
		"\7\3\2\2\u02d5\u02da\58\35\2\u02d6\u02d7\7\4\2\2\u02d7\u02d9\58\35\2\u02d8"+
		"\u02d6\3\2\2\2\u02d9\u02dc\3\2\2\2\u02da\u02d8\3\2\2\2\u02da\u02db\3\2"+
		"\2\2\u02db\u02dd\3\2\2\2\u02dc\u02da\3\2\2\2\u02dd\u02de\7\5\2\2\u02de"+
		"\u02fd\3\2\2\2\u02df\u02e1\7r\2\2\u02e0\u02df\3\2\2\2\u02e0\u02e1\3\2"+
		"\2\2\u02e1\u02e2\3\2\2\2\u02e2\u02e3\7R\2\2\u02e3\u02e4\7\3\2\2\u02e4"+
		"\u02e5\5\b\5\2\u02e5\u02e6\7\5\2\2\u02e6\u02fd\3\2\2\2\u02e7\u02e9\7r"+
		"\2\2\u02e8\u02e7\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea"+
		"\u02eb\7b\2\2\u02eb\u02ee\5@!\2\u02ec\u02ed\7\66\2\2\u02ed\u02ef\5@!\2"+
		"\u02ee\u02ec\3\2\2\2\u02ee\u02ef\3\2\2\2\u02ef\u02fd\3\2\2\2\u02f0\u02f2"+
		"\7[\2\2\u02f1\u02f3\7r\2\2\u02f2\u02f1\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3"+
		"\u02f4\3\2\2\2\u02f4\u02fd\7s\2\2\u02f5\u02f7\7[\2\2\u02f6\u02f8\7r\2"+
		"\2\u02f7\u02f6\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u02fa"+
		"\7\60\2\2\u02fa\u02fb\7F\2\2\u02fb\u02fd\5@!\2\u02fc\u02bf\3\2\2\2\u02fc"+
		"\u02c2\3\2\2\2\u02fc\u02c9\3\2\2\2\u02fc\u02d1\3\2\2\2\u02fc\u02e0\3\2"+
		"\2\2\u02fc\u02e8\3\2\2\2\u02fc\u02f0\3\2\2\2\u02fc\u02f5\3\2\2\2\u02fd"+
		"?\3\2\2\2\u02fe\u02ff\b!\1\2\u02ff\u0303\5B\"\2\u0300\u0301\t\b\2\2\u0301"+
		"\u0303\5@!\6\u0302\u02fe\3\2\2\2\u0302\u0300\3\2\2\2\u0303\u030f\3\2\2"+
		"\2\u0304\u0305\f\5\2\2\u0305\u0306\t\t\2\2\u0306\u030e\5@!\6\u0307\u0308"+
		"\f\4\2\2\u0308\u0309\t\b\2\2\u0309\u030e\5@!\5\u030a\u030b\f\3\2\2\u030b"+
		"\u030c\7\u00d3\2\2\u030c\u030e\5@!\4\u030d\u0304\3\2\2\2\u030d\u0307\3"+
		"\2\2\2\u030d\u030a\3\2\2\2\u030e\u0311\3\2\2\2\u030f\u030d\3\2\2\2\u030f"+
		"\u0310\3\2\2\2\u0310A\3\2\2\2\u0311\u030f\3\2\2\2\u0312\u0313\b\"\1\2"+
		"\u0313\u0346\7s\2\2\u0314\u0315\5X-\2\u0315\u0316\5D#\2\u0316\u0346\3"+
		"\2\2\2\u0317\u0318\7\u00df\2\2\u0318\u0346\5D#\2\u0319\u0346\5Z.\2\u031a"+
		"\u0346\5J&\2\u031b\u0346\5D#\2\u031c\u0346\7\u00d6\2\2\u031d\u031e\5V"+
		",\2\u031e\u031f\7\3\2\2\u031f\u0320\7\u00d0\2\2\u0320\u0322\7\5\2\2\u0321"+
		"\u0323\5T+\2\u0322\u0321\3\2\2\2\u0322\u0323\3\2\2\2\u0323\u0346\3\2\2"+
		"\2\u0324\u0325\5V,\2\u0325\u0331\7\3\2\2\u0326\u0328\5\"\22\2\u0327\u0326"+
		"\3\2\2\2\u0327\u0328\3\2\2\2\u0328\u0329\3\2\2\2\u0329\u032e\58\35\2\u032a"+
		"\u032b\7\4\2\2\u032b\u032d\58\35\2\u032c\u032a\3\2\2\2\u032d\u0330\3\2"+
		"\2\2\u032e\u032c\3\2\2\2\u032e\u032f\3\2\2\2\u032f\u0332\3\2\2\2\u0330"+
		"\u032e\3\2\2\2\u0331\u0327\3\2\2\2\u0331\u0332\3\2\2\2\u0332\u0333\3\2"+
		"\2\2\u0333\u0335\7\5\2\2\u0334\u0336\5T+\2\u0335\u0334\3\2\2\2\u0335\u0336"+
		"\3\2\2\2\u0336\u0346\3\2\2\2\u0337\u0338\7\3\2\2\u0338\u0339\5\b\5\2\u0339"+
		"\u033a\7\5\2\2\u033a\u0346\3\2\2\2\u033b\u033c\7;\2\2\u033c\u033d\7\3"+
		"\2\2\u033d\u033e\5\b\5\2\u033e\u033f\7\5\2\2\u033f\u0346\3\2\2\2\u0340"+
		"\u0346\5X-\2\u0341\u0342\7\3\2\2\u0342\u0343\58\35\2\u0343\u0344\7\5\2"+
		"\2\u0344\u0346\3\2\2\2\u0345\u0312\3\2\2\2\u0345\u0314\3\2\2\2\u0345\u0317"+
		"\3\2\2\2\u0345\u0319\3\2\2\2\u0345\u031a\3\2\2\2\u0345\u031b\3\2\2\2\u0345"+
		"\u031c\3\2\2\2\u0345\u031d\3\2\2\2\u0345\u0324\3\2\2\2\u0345\u0337\3\2"+
		"\2\2\u0345\u033b\3\2\2\2\u0345\u0340\3\2\2\2\u0345\u0341\3\2\2\2\u0346"+
		"\u034c\3\2\2\2\u0347\u0348\f\4\2\2\u0348\u0349\7\6\2\2\u0349\u034b\5X"+
		"-\2\u034a\u0347\3\2\2\2\u034b\u034e\3\2\2\2\u034c\u034a\3\2\2\2\u034c"+
		"\u034d\3\2\2\2\u034dC\3\2\2\2\u034e\u034c\3\2\2\2\u034f\u0356\7\u00d4"+
		"\2\2\u0350\u0353\7\u00d5\2\2\u0351\u0352\7\u00b6\2\2\u0352\u0354\7\u00d4"+
		"\2\2\u0353\u0351\3\2\2\2\u0353\u0354\3\2\2\2\u0354\u0356\3\2\2\2\u0355"+
		"\u034f\3\2\2\2\u0355\u0350\3\2\2\2\u0356E\3\2\2\2\u0357\u0358\t\n\2\2"+
		"\u0358G\3\2\2\2\u0359\u035a\t\13\2\2\u035aI\3\2\2\2\u035b\u035c\t\f\2"+
		"\2\u035cK\3\2\2\2\u035d\u035e\b\'\1\2\u035e\u035f\7\r\2\2\u035f\u0360"+
		"\7\u00ca\2\2\u0360\u0361\5L\'\2\u0361\u0362\7\u00cc\2\2\u0362\u0388\3"+
		"\2\2\2\u0363\u0364\7f\2\2\u0364\u0365\7\u00ca\2\2\u0365\u0366\5L\'\2\u0366"+
		"\u0367\7\4\2\2\u0367\u0368\5L\'\2\u0368\u0369\7\u00cc\2\2\u0369\u0388"+
		"\3\2\2\2\u036a\u036b\7\u0096\2\2\u036b\u036c\7\3\2\2\u036c\u036d\5X-\2"+
		"\u036d\u0374\5L\'\2\u036e\u036f\7\4\2\2\u036f\u0370\5X-\2\u0370\u0371"+
		"\5L\'\2\u0371\u0373\3\2\2\2\u0372\u036e\3\2\2\2\u0373\u0376\3\2\2\2\u0374"+
		"\u0372\3\2\2\2\u0374\u0375\3\2\2\2\u0375\u0377\3\2\2\2\u0376\u0374\3\2"+
		"\2\2\u0377\u0378\7\5\2\2\u0378\u0388\3\2\2\2\u0379\u0385\5P)\2\u037a\u037b"+
		"\7\3\2\2\u037b\u0380\5N(\2\u037c\u037d\7\4\2\2\u037d\u037f\5N(\2\u037e"+
		"\u037c\3\2\2\2\u037f\u0382\3\2\2\2\u0380\u037e\3\2\2\2\u0380\u0381\3\2"+
		"\2\2\u0381\u0383\3\2\2\2\u0382\u0380\3\2\2\2\u0383\u0384\7\5\2\2\u0384"+
		"\u0386\3\2\2\2\u0385\u037a\3\2\2\2\u0385\u0386\3\2\2\2\u0386\u0388\3\2"+
		"\2\2\u0387\u035d\3\2\2\2\u0387\u0363\3\2\2\2\u0387\u036a\3\2\2\2\u0387"+
		"\u0379\3\2\2\2\u0388\u038d\3\2\2\2\u0389\u038a\f\7\2\2\u038a\u038c\7\r"+
		"\2\2\u038b\u0389\3\2\2\2\u038c\u038f\3\2\2\2\u038d\u038b\3\2\2\2\u038d"+
		"\u038e\3\2\2\2\u038eM\3\2\2\2\u038f\u038d\3\2\2\2\u0390\u0393\7\u00d7"+
		"\2\2\u0391\u0393\5L\'\2\u0392\u0390\3\2\2\2\u0392\u0391\3\2\2\2\u0393"+
		"O\3\2\2\2\u0394\u0399\7\u00dd\2\2\u0395\u0399\7\u00de\2\2\u0396\u0399"+
		"\7\u00df\2\2\u0397\u0399\5X-\2\u0398\u0394\3\2\2\2\u0398\u0395\3\2\2\2"+
		"\u0398\u0396\3\2\2\2\u0398\u0397\3\2\2\2\u0399Q\3\2\2\2\u039a\u039b\7"+
		"\u00c1\2\2\u039b\u039c\58\35\2\u039c\u039d\7\u00ae\2\2\u039d\u039e\58"+
		"\35\2\u039eS\3\2\2\2\u039f\u03a0\7A\2\2\u03a0\u03a1\7\3\2\2\u03a1\u03a2"+
		"\7\u00c2\2\2\u03a2\u03a3\5:\36\2\u03a3\u03a4\7\5\2\2\u03a4U\3\2\2\2\u03a5"+
		"\u03aa\5X-\2\u03a6\u03a7\7\6\2\2\u03a7\u03a9\5X-\2\u03a8\u03a6\3\2\2\2"+
		"\u03a9\u03ac\3\2\2\2\u03aa\u03a8\3\2\2\2\u03aa\u03ab\3\2\2\2\u03abW\3"+
		"\2\2\2\u03ac\u03aa\3\2\2\2\u03ad\u03b2\7\u00d9\2\2\u03ae\u03b2\5\\/\2"+
		"\u03af\u03b2\7\u00dc\2\2\u03b0\u03b2\7\u00da\2\2\u03b1\u03ad\3\2\2\2\u03b1"+
		"\u03ae\3\2\2\2\u03b1\u03af\3\2\2\2\u03b1\u03b0\3\2\2\2\u03b2Y\3\2\2\2"+
		"\u03b3\u03b6\7\u00d8\2\2\u03b4\u03b6\7\u00d7\2\2\u03b5\u03b3\3\2\2\2\u03b5"+
		"\u03b4\3\2\2\2\u03b6[\3\2\2\2\u03b7\u03b8\t\r\2\2\u03b8]\3\2\2\2\u0096"+
		"rwy\u0087\u008b\u0092\u009b\u009e\u00a2\u00ab\u00ae\u00b2\u00b5\u00b9"+
		"\u00c0\u00c4\u00cc\u00cf\u00d3\u00dc\u00df\u00e3\u00e5\u00e9\u00f0\u00f7"+
		"\u00fc\u0101\u0105\u0108\u010b\u010e\u0110\u0112\u0117\u011c\u0120\u0129"+
		"\u012c\u0130\u0133\u0137\u013e\u0142\u0148\u014d\u0152\u0156\u0159\u015c"+
		"\u015f\u0161\u0163\u0168\u016d\u0171\u017a\u017d\u0181\u0185\u018c\u0197"+
		"\u019b\u019e\u01a1\u01a4\u01a6\u01a8\u01ad\u01b2\u01b6\u01bf\u01c2\u01c6"+
		"\u01c9\u01cd\u01d4\u01d8\u01e2\u01e6\u01e9\u01ec\u01ef\u01f1\u01f3\u01f8"+
		"\u01fd\u0201\u020a\u020d\u0211\u0213\u021f\u0225\u0229\u022d\u0246\u0249"+
		"\u0250\u0257\u025b\u0268\u026c\u0270\u0274\u0276\u0281\u0286\u028a\u0291"+
		"\u0293\u029a\u02a6\u02ae\u02b6\u02b8\u02bd\u02c9\u02d1\u02da\u02e0\u02e8"+
		"\u02ee\u02f2\u02f7\u02fc\u0302\u030d\u030f\u0322\u0327\u032e\u0331\u0335"+
		"\u0345\u034c\u0353\u0355\u0374\u0380\u0385\u0387\u038d\u0392\u0398\u03aa"+
		"\u03b1\u03b5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}