import java.util.ArrayList;
import java.util.List;

public class CamelCaseConverter
{
	String regex = "(?<!(^|[A-Z0-9]))(?=[A-Z0-9])|(?<!(^|[^A-Z]))(?=[0-9])|"
				 + "(?<!(^|[^0-9]))(?=[A-Za-z])|(?<!^)(?=[A-Z][a-z])";
	
	public boolean isEmpty( String camelCaseString )
	{
		return ( camelCaseString == "" ) | ( camelCaseString == null ) | ( camelCaseString == " " );
	}

	public boolean startWithNumber( String camelCaseString )
	{
		return Character.isDigit( camelCaseString.charAt( 0 ) );
	}

	public boolean haveSpeacialChars( String camelCaseString )
	{
		boolean error = false;
		for (int i = 0 ; i < camelCaseString.length() ; i++ )
		{
			if ( !Character.isLetter( camelCaseString.charAt( i ) ) && 
				 !Character.isDigit( camelCaseString.charAt( i ) ) )
			{
				error = true;
				break;
			}
		}
		return error;
	}

	public List<String> ConvertCamelCase( String camelCaseString ) {
		if ( isEmpty( camelCaseString ) )
		{
			throw new StringException( "Empty String" );
		}
		else if ( startWithNumber( camelCaseString ) )
		{
			throw new StringException( "String starts with number" );
		}
		else if ( haveSpeacialChars( camelCaseString ) )
		{
			throw new StringException( "String has special chars" );
		}
		else
		{
			return stringToLowerCase( camelCaseString.split( regex ) );
		}
	}

	public List<String> stringToLowerCase( String[] camelCaseArray ) 
	{
		List<String> convertedList = new ArrayList<String>(); 
		
		for (int i = 0 ; i < camelCaseArray.length ; i++ )
		{
			convertedList.add( camelCaseArray[i].toLowerCase() );
			System.out.println( "String #" + ( i + 1 ) + ": " + convertedList.get( i ) );
		}
		return convertedList;
	}
}
