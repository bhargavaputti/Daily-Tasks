import React, { useState, useEffect } from 'react';

const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

export default function RegisterForm() {
  const [values, setValues] = useState({
    fullName: '',
    email: '',
    password: '',
    confirmPassword: '',
  });

  const [errors, setErrors] = useState({});
  const [isValid, setIsValid] = useState(false);

  // Validate in real-time whenever values change
  useEffect(() => {
    const e = {};

    if (!values.fullName.trim()) {
      e.fullName = 'Full name is required.';
    }

    if (!values.email.trim()) {
      e.email = 'Email is required.';
    } else if (!emailRegex.test(values.email)) {
      e.email = 'Enter a valid email.';
    }

    if (!values.password) {
      e.password = 'Password is required.';
    } else if (values.password.length < 6) {
      e.password = 'Password must be at least 6 characters.';
    }

    if (!values.confirmPassword) {
      e.confirmPassword = 'Please confirm your password.';
    } else if (values.confirmPassword !== values.password) {
      e.confirmPassword = 'Passwords do not match.';
    }

    setErrors(e);
    setIsValid(Object.keys(e).length === 0);
  }, [values]);

  function handleChange(e) {
    const { name, value } = e.target;
    setValues(prev => ({ ...prev, [name]: value }));
  }

  function handleSubmit(e) {
    e.preventDefault();
    if (!isValid) return;
    // Basic success behaviour
    alert(`Registered successfully!\nName: ${values.fullName}\nEmail: ${values.email}`);
    setValues({ fullName: '', email: '', password: '', confirmPassword: '' });
  }

  // Simple inline styles to keep file self-contained (optional)
  const inputStyle = { display: 'block', width: '100%', padding: '8px', marginBottom: '6px' };
  const labelStyle = { fontWeight: 600, marginTop: '10px' };
  const errStyle = { color: '#b91c1c', fontSize: '13px', marginBottom: '6px' };
  const btnStyle = { backgroundColor: isValid? '#1b771bff': 'none', padding: '10px 16px', marginTop: '12px', cursor: isValid ? 'pointer' : 'not-allowed' };

  return (
    <div style={{ maxWidth: 480, margin: '40px auto', padding: 20, fontFamily: 'Inter, Roboto, Arial'}}>
      <h2>Registration Form</h2>
      <form onSubmit={handleSubmit} noValidate>
        <label style={labelStyle} htmlFor="fullName">Full Name</label>
        <input
          id="fullName"
          name="fullName"
          type="text"
          value={values.fullName}
          onChange={handleChange}
          style={inputStyle}
        />
        {errors.fullName && <div style={errStyle}>{errors.fullName}</div>}

        <label style={labelStyle} htmlFor="email">Email</label>
        <input
          id="email"
          name="email"
          type="email"
          value={values.email}
          onChange={handleChange}
          style={inputStyle}
        />
        {errors.email && <div style={errStyle}>{errors.email}</div>}

        <label style={labelStyle} htmlFor="password">Password</label>
        <input
          id="password"
          name="password"
          type="password"
          value={values.password}
          onChange={handleChange}
          style={inputStyle}
        />
        {errors.password && <div style={errStyle}>{errors.password}</div>}

        <label style={labelStyle} htmlFor="confirmPassword">Confirm Password</label>
        <input
          id="confirmPassword"
          name="confirmPassword"
          type="password"
          value={values.confirmPassword}
          onChange={handleChange}
          style={inputStyle}
        />
        {errors.confirmPassword && <div style={errStyle}>{errors.confirmPassword}</div>}

        <button type="submit" disabled={!isValid} style={btnStyle}>
          Register
        </button>
      </form>

      <div style={{ marginTop: 12, color: '#374151' }}>
        <small>Form valid: {isValid ? 'Yes' : 'No'}</small>
      </div>
    </div>
  );
}
