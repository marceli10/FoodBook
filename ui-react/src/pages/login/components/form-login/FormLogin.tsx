import React, {FormEvent} from 'react';
import {Link} from 'react-router-dom';
import './FormLoginStyle.scss';

const FormLogin: React.FunctionComponent = () => {
    const [email, setEmail] = React.useState<string>('');
    const [password, setPassword] = React.useState<string>('');

    const login = (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        console.log('login...');
    };

    return (
        <form className='form-container' onSubmit={login}>
            <div className='form-item'>
                <label>email</label>
                <input
                    type='text'
                    placeholder='example@email.com'
                    value={email}
                    onChange={e => setEmail(e.target.value)}
                />
            </div>
            <div className='form-item'>
                <label>password</label>
                <input
                    type='password'
                    placeholder='Enter your password'
                    value={password}
                    onChange={e => setPassword(e.target.value)}
                />
            </div>
            <div className='form-item'>
                <input type='submit' value='Log in' className='form-login-button'/>
                <span className='form-signup-link'>Don't have an account? <Link to='/signup'> Sign up</Link></span>
            </div>
        </form>
    );
};

export default FormLogin;