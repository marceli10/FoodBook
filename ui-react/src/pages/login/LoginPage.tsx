import React from 'react';
import FormLogin from './components/form-login/FormLogin';
import './LoginPageStyle.scss';
import SocialLogin from './components/social-login/SocialLogin';

const LoginPage: React.FunctionComponent = () => {
    return (
        <main className='login-page'>
            <div className='login-container'>
                <FormLogin/>
                <SocialLogin />
            </div>
        </main>
    );
};

export default LoginPage;