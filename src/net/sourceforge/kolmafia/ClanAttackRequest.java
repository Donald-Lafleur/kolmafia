/**
 * Copyright (c) 2005-2007, KoLmafia development team
 * http://kolmafia.sourceforge.net/
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  [1] Redistributions of source code must retain the above copyright
 *      notice, this list of conditions and the following disclaimer.
 *  [2] Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions and the following disclaimer in
 *      the documentation and/or other materials provided with the
 *      distribution.
 *  [3] Neither the name "KoLmafia" nor the names of its contributors may
 *      be used to endorse or promote products derived from this software
 *      without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package net.sourceforge.kolmafia;

public class ClanAttackRequest extends KoLRequest implements Comparable
{
	private String name;
	private int goodies;

	public ClanAttackRequest( String id, String name, int goodies )
	{
		super( "clan_attack.php" );
		this.addFormField( "whichclan", id );

		this.name = name;
		this.goodies = goodies;
	}

	public void run()
	{
		KoLmafia.updateDisplay( "Attacking " + this.name + "..." );
		super.run();
	}

	public void processResults()
	{	KoLmafia.updateDisplay( "Attack request processed." );
	}

	public String toString()
	{	return this.name + " (" + COMMA_FORMAT.format( this.goodies ) + " " + (this.goodies == 1 ? "bag" : "bags") + ")";
	}

	public int compareTo( Object o )
	{	return o == null || !(o instanceof ClanAttackRequest) ? -1 : this.compareTo( (ClanAttackRequest) o );
	}

	public int compareTo( ClanAttackRequest car )
	{
		int goodiesDifference = car.goodies - this.goodies;
		return goodiesDifference != 0 ? goodiesDifference : this.name.compareToIgnoreCase( car.name );
	}
}

